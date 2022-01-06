# Criacao de uma classe carro conforme os requisitos:

1. Criar uma classe "carro", ele terá algumas propriedades: marca, modelo, placa, ligado, nível de combustível, velocidade e marcha:
2. Não há limitações ou validações para marca, modelo ou placa;
3. O carro poderá se mover (para frente, trás ou não fazer nada) ao acelerar;
4. O carro terá dois status: ligado e desligado (ambos controlados pela mesma propriedade);
5. A velocidade mínima será 0 e a máxima 120 km/h;
6. A marcha vai se 1 a 6, terá ré e ponto morto;
7. Validar se ao mover o carro existe combustível;
8. A cada movimento o combustível reduz (considerar uma escala de 0 a 50, sendo 0 vazio, 10 está na reserva, 25 meio tanque e 50 tanque cheio). Definição do quantidade gasta a cada 
vez que o carro andar ou ligar será sua;
9. Ter conta giro: se passar de 3, pode passar marcha. Menor que 2, pode reduzir. Não validar conta giro para ré, marcha máxima ou mínima. 
10.Ter um método para realizar abastecimento;
11. Ter um método para o carro andar;
12. Ter um método para o carro passar a marcha;
13. Ter um método para o carro parar;
14. Ter um método para o carro desligar/desligar;
15. Ter um método para aumentar/reduzir o conta giro para definir se pode avançar ou reduzir marcha;

# Tecnologias e conceitos usados

Projeto criado com SpringBoot, desenvolvido em java usando modelo de arquitetura MVC.
