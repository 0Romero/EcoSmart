document.addEventListener('DOMContentLoaded', function () {
    const chatForm = document.querySelector('#chat-form');
    const messageInput = document.querySelector('#message-input');
    const chatResponse = document.querySelector('#chat-response');
    
    // Envio da mensagem ao servidor
    chatForm.addEventListener('submit', function (e) {
        e.preventDefault();
        
        const message = messageInput.value.trim();
        
        if (message) {
            // Cria o envio de mensagem ao servidor via HTMX
            htmx.ajax('POST', '/api/chat', {
                target: '#chat-response',
                swap: 'outerHTML',
                values: {
                    message: message
                }
            });
            
            // Limpar o campo de input
            messageInput.value = '';
        }
    });
    
    // Recebe a resposta do backend e exibe
    document.body.addEventListener('htmx:afterSwap', function (event) {
        if (event.target.id === 'chat-response') {
            const response = event.target.innerHTML;
            chatResponse.innerHTML = response;
        }
    });
});
