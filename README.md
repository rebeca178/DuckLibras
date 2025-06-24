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
<li>Baixe o projeto da forma que desejar</li>
<li>Abra a pasta do projeto</li>
<li>Abra a pasta xiang-app</li>
<li>Rode o comando: <code>npm install</code> para instalar as dependências do Node</li>
<li>Depois rode o comando <code>npm run build</code> para gerar as estilizações</li>
<li>(Opcional) Rode o comando <code>composer install</code> para instalar as dependências do Composer</li>
<li>Execute o comando de migrations rodando <code>php artisan migrate</code></li>
<li>Execute o comando <code>composer run dev</code> para rodar a aplicação no modo desenvolvedor</li>

# 🐞 Bugs:
<p>Na inicialização do projeto, as portas de entrada para outros layouts estão um pouco fora do lugar!</p>