package com.example.appquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuizApp() {
    var screenIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableIntStateOf(-1) }
    var showFeedback by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf(false) }
    var score by remember { mutableIntStateOf(0) }
    var quizFinished by remember { mutableStateOf(false) }

    val questions = listOf(
        Question("Qual a capital do Brasil?", listOf("Brasília", "Rio de Janeiro", "São Paulo"), 0),
        Question("Quanto é 5 x 6?", listOf("30", "11", "56"), 0),
        Question("Qual planeta é conhecido como planeta vermelho?", listOf("Marte", "Júpiter", "Saturno"), 0),
        Question("Quem pintou a Mona Lisa?", listOf("Van Gogh", "Da Vinci", "Picasso"), 1),
        Question("O que é H2O?", listOf("Água", "Oxigênio", "Hidrogênio"), 0),
        Question("Em que país fica a Torre Eiffel?", listOf("Itália", "França", "Alemanha"), 1),
        Question("Quantos lados tem um quadrado?", listOf("4", "5", "6"), 0),
        Question("Qual é o maior oceano do mundo?", listOf("Atlântico", "Índico", "Pacífico"), 2),
        Question("Quem escreveu 'Dom Casmurro'?", listOf("Machado de Assis", "José de Alencar", "Clarice Lispector"), 0),
        Question("Qual é o resultado de 12 / 4?", listOf("3", "2", "4"), 0)
    )

    when {
        quizFinished -> ResultScreen(score) {
            screenIndex = 0
            selectedOption = -1
            showFeedback = false
            isCorrect = false
            score = 0
            quizFinished = false
        }
        showFeedback -> FeedbackScreen(isCorrect) {
            showFeedback = false
            selectedOption = -1
            screenIndex++
            if (screenIndex >= questions.size) {
                quizFinished = true
            }
        }
        else -> QuestionScreen(
            question = questions[screenIndex],
            selectedOption = selectedOption,
            onOptionSelected = { selectedOption = it },
            onConfirm = {
                isCorrect = selectedOption == questions[screenIndex].correctAnswer
                if (isCorrect) score++
                showFeedback = true
            }
        )
    }
}

data class Question(val text: String, val options: List<String>, val correctAnswer: Int)

@Composable
fun QuestionScreen(
    question: Question,
    selectedOption: Int,
    onOptionSelected: (Int) -> Unit,
    onConfirm: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = question.text,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                question.options.forEachIndexed { index, option ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (selectedOption == index)
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                            else
                                MaterialTheme.colorScheme.surface
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .selectable(
                                selected = selectedOption == index,
                                onClick = { onOptionSelected(index) }
                            )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            RadioButton(
                                selected = selectedOption == index,
                                onClick = { onOptionSelected(index) }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = option, fontSize = 18.sp)
                        }
                    }
                }
            }

            Button(
                onClick = onConfirm,
                enabled = selectedOption != -1,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Confirmar", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun FeedbackScreen(correct: Boolean, onNext: () -> Unit) {
    val feedbackColor = if (correct) Color(0xFF4CAF50) else Color(0xFFF44336)
    val feedbackText = if (correct) "Você acertou! 🎉" else "Você errou! 😔"

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(feedbackColor.copy(alpha = 0.1f)),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = feedbackText,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = feedbackColor
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = onNext, shape = RoundedCornerShape(10.dp)) {
                Text("Próxima", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun ResultScreen(score: Int, onRestart: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = "Quiz finalizado!",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Você acertou $score de 10",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onRestart, shape = RoundedCornerShape(12.dp)) {
                Text("Recomeçar", fontSize = 16.sp)
            }
        }
    }
}
