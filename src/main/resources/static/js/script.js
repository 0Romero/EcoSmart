// Exibe uma mensagem de boas-vindas ao carregar a página
window.addEventListener('DOMContentLoaded', () => {
    alert('Bem-vindo ao EcoSmart! Pronto para gerenciar sua energia?');
});

// Adiciona animação ao passar o mouse sobre os cartões de funcionalidades
document.querySelectorAll('.feature-card').forEach(card => {
    card.addEventListener('mouseover', () => {
        card.style.transform = 'scale(1.05)';
        card.style.boxShadow = '0 6px 10px rgba(0, 0, 0, 0.2)';
    });

    card.addEventListener('mouseout', () => {
        card.style.transform = 'scale(1)';
        card.style.boxShadow = '0 4px 6px rgba(0, 0, 0, 0.1)';
    });
});

// Função para redirecionar ao clicar em um botão (se necessário futuramente)
function redirectTo(url) {
    window.location.href = url;
}

document.addEventListener("DOMContentLoaded", function() {
    const chatForm = document.getElementById("chat-form");
    const chatInput = document.getElementById("chat-input");
    const chatContainer = document.getElementById("chat-container");

    // Função para exibir as mensagens no chat
    function displayMessage(content, sender) {
        const messageDiv = document.createElement("div");
        messageDiv.classList.add("message", sender);
        messageDiv.textContent = content;
        chatContainer.appendChild(messageDiv);
        chatContainer.scrollTop = chatContainer.scrollHeight;
    }

    // Função para enviar a pergunta para a API da OpenAI e obter a resposta
    async function getAssistantResponse(userInput) {
        const apiKey ='Your API Key'; // Substitua com sua chave real

        const response = await fetch('https://api.openai.com/v1/chat/completions', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${apiKey}`
            },
            body: JSON.stringify({
                model: 'gpt-3.5-turbo', // Ou use o modelo que você preferir
                messages: [{ role: 'user', content: userInput }]
            })
        });

        const data = await response.json();
        return data.choices[0].message.content.trim(); // Retorna a resposta gerada pela OpenAI
    }

    // Envio da pergunta
    chatForm.addEventListener("submit", async function(event) {
        event.preventDefault();
        const userMessage = chatInput.value.trim();
        if (userMessage) {
            displayMessage(userMessage, "user");
            const assistantResponse = await getAssistantResponse(userMessage);
            displayMessage(assistantResponse, "assistant");
            chatInput.value = ""; // Limpa o campo de entrada
        }
    });
});
