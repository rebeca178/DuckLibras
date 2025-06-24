# Duck Libras

Duck Libras - Aprenda 'Libras' de forma fácil.

O projeto Duck Libras consiste em um aplicativo móvel para aprendizagem de Libras de forma interativa e convidativa. Muitas pessoas querem ou precisam aprender Libras, seja por motivos profissionais, sociais ou pessoais, e ao mesmo tempo encontram dificuldade em achar esse conteúdo de forma gratuita e/ou organizada. O aplicativo se propõe a entregar um curso de Libras do básico ao avançado de forma descontraída.

# ⚙️ Tecnologias 

<div style="display: inline_block">
  <img style="padding: 5px;"  align="center" alt="Docker" src="https://img.shields.io/badge/Docker-8e00cd?style=for-the-badge&logo=docker&logoColor=white">
</div>

> <p>Android Studio -> Estilização do App</p>
> <p>Docker -> API</p>

# 🚀 Como rodar

## 🐳 Android Studio / Docker
Android Studio é necessário para essa execução.
<li>Baixe o projeto da forma que desejar</li>
<li>Abra a pasta do projeto no Android Studio</li>
<li>Abra um navegador e acesse: https://ducklibras-p7pz.onrender.com</li>
<li>Aguarde até que a API esteja rodando completamente</li>
<li>Espere o Android instalar todas as dependências necessárias para abrir o arquivo</li>
<li>Rode o projeto</li>

# ⚠️ Atenção
<p>Este projeto é apenas um protótipo, então aguarde as novas versões.</p>

## 👩🏻‍💻 Modo Host
Utilizamos o Render para criação do banco de dados e para subir a API na nuvem.
<li>Baixe a API</li>
<li>Abra a pasta do projeto no Render através do Git</li>
<li>Crie um banco de dados</li>
<li>Logo em seguida, suba a API na nuvem</li>
<li>Selecione o projeto que será a main, onde o projeto em si está localizado</li>
<li>Preencha os campos a seguir</li>
<li>Language: Docker</li>
<li>Root Directory: api/</li>
<li>Instance Type: Escolha o que desejar</li>

<li>Environment Variables: </li>
<li>Adicione 3 variáveis, cada uma contendo: </li>
<li>DATABASE_USERNAME</li>
<li>DATABASE_PASSWORD</li>
<li>DATABASE_URL</li>

<p>Abra uma nova aba em seu navegador com o banco de dados criado</p>
<li>Preencha o valor de cada variável no campo VALUE</li>
<li>No final da URL: comece com jdbc:, pegue a URL interna e apague tudo do '@' para a esquerda até chegar em '//'</li>
<li>Depois, adicione a porta 5432 à direita, antes do / (que é o nome do banco), ficando assim: :5432/NomeDoBanco</li>

# 🐞 Bugs:
<p>Na inicialização do projeto, as portas de entrada para outros layouts estão um pouco fora do lugar!</p>