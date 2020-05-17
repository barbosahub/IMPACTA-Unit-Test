import java.util.Random;

public class Nickname {
    private int coins;

    /*Classe Mock de Coins*/
    public Nickname(){  coinsGame();  }

    /*Classe privada de CoinsGame*/
    private void coinsGame(){
        coins = 0;
    }

    /*Classe mock de Coins*/
    public int retornaCoins (int coins){
        if (coins > 0 ) {

            if (coins < 10) {
                System.out.println("Depósito não pode ser menor que 10");
            } else if (coins <= 100) {
                setCoins(getCoins() + coins);
            }
            else {
                System.out.println("Depósito não pode ser maior que 100");
            }
        }
        return getTotal();
    }

    /*Classe destinada a jogadores escolherem um apelido para um personagem online*/
    public int retornaJogador(String caracteres, String email, int idade){

        Random random = new Random();
        int qtd = caracteres.length();
        int validaemail = email.indexOf('@');

        int senha = random.nextInt(9999999);

        if (idade >= 18){
            if (email.length() < 1){
                System.out.println("E-mail: "+email+" inválido");
            }else{
                if (validaemail > 0) {
                    if (qtd  > 10){
                        System.out.println("Não é permitido nickname com mais de 10 caracteres");
                    }else if (qtd < 1){
                        System.out.println("Não é permitido nickname com menos que 1 caracteres");
                    }else if (caracteres.indexOf(' ') >= 0 ){
                        System.out.println("Não é permitido espaços");
                    }else if (caracteres.contains("/") || caracteres.contains("_") || caracteres.contains("+") || caracteres.contains("-")){
                        System.out.println("Não é permitido caracteres '/', '_', '+', '-'");
                    }else {
                        System.out.println("Bem vindo ao jogo: " + caracteres + " | Senha de primeiro acesso: " + senha + " | Idade:" +idade);
                    }
                }else {
                    System.out.println("E-mail: "+email+" inválido");
                }
            }
        }else{
            System.out.println("Clickjogos.com.br");
        }
        return qtd;
    }

    private void setCoins(int coins) {
        this.coins = coins;
    }
    public int getCoins(){return coins;}

    public int getTotal(){return coins;}
}
