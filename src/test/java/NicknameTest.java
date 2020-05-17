import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

public class NicknameTest {

    /*Classe destinada a jogadores escolherem um apelido para um personagem online*/

    /*Comandos*/
        /* @Test 1: Validar quantidades de entrada máxima de caracteres*/
        /* @Test 2: Validar quantidades de entrada minima de caracteres*/
        /* @Test 3: Validar se existe espaço*/
        /* @Test 4: Validar se existe caracteres '/', '_', '+', '-' */
        /* @Test 5: Validar se e-mail é valido */


    @RunWith(PowerMockRunner.class)
    @PrepareForTest(Nickname.class)
    public class CoinsMock {

    }
    private int coinsGamedepmaior;
    private int coinsGamedepmenor;
    private int coinsGamedepmock;

    @Before
    public void prepareTests(){
        coinsGamedepmaior = 101;
    }
    @Before
    public void prepareTests1(){
        coinsGamedepmenor = 1;
    }
    @Before
    public void prepareTests2(){
        coinsGamedepmock = 100;
    }


    @Test
    public void testEnviaCoinsMock() throws Exception {
        //arrange
        Nickname nickname = new Nickname();
        final String METHOD="getCoins";

        Nickname spy = PowerMockito.spy(nickname);
        PowerMockito.when(spy, METHOD).thenReturn( (int) 1000);

        int actual;
        int expect = 1100;

        //act
        actual = spy.retornaCoins(coinsGamedepmock);

        //assert
        Assert.assertEquals(expect, actual, 0);
        PowerMockito.verifyPrivate(spy, Mockito
                .times(1))
                .invoke("getCoins");
    }
    @Test
    public void testEnviaCoinsMenor() throws Exception {
        //arrange
        Nickname nickname = new Nickname();
        final String METHOD="getCoins";

        int actual;
        int expect = 0;

        //act
        actual = nickname.retornaCoins(coinsGamedepmenor);

        //assert
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void testEnviaCoinsMaior() throws Exception {
        //arrange
        Nickname nickname = new Nickname();
        final String METHOD="getCoins";

        int actual;
        int expect = 0;
        //act
        actual = nickname.retornaCoins(coinsGamedepmaior);

        //assert
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testMaxCaracteres(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int expect = 14;

        //act
        actual = nickname.retornaJogador("Matadosdenoobs","jogador@gmail.com",18);

        //assert
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testMinCaracteres(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int expect = 0;

        //act
        actual = nickname.retornaJogador("","jogador@gmail.com",18);

        //assert
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void testEspacoCaracteres(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int expect = 2;

        //act
        actual = nickname.retornaJogador("R ","jogador@gmail.com",18);

        //assert
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void testEspecialCaracteres(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int expect = 9;

        //act
        actual = nickname.retornaJogador("nick_name","jogador@gmail.com",18);

        //assert
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void testEmailInvalido(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int expect = 8;

        //act
        actual = nickname.retornaJogador("nickname","jogadorgmail.com",18);

        //assert
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void testEmailBranco(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int expect = 8;

        //act
        actual = nickname.retornaJogador("nickname","",18);

        //assert
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void testCorreto(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int expect = 8;

        //act
        actual = nickname.retornaJogador("username","username@gmail.com",18);

        //assert
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void testIdadeMaior(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int qtdcaracteres = 4;

        //act
        actual = nickname.retornaJogador("Noob","username@gmail.com",18);

        //assert
        Assert.assertEquals(qtdcaracteres,actual);
    }
    @Test
    public void testIdadeMenor(){
        //arrange
        Nickname nickname = new Nickname();
        int actual;
        int qtdcaracteres = 8;

        //act
        actual = nickname.retornaJogador("username","username@gmail.com",17);

        //assert
        Assert.assertEquals(qtdcaracteres,actual);
    }
}
