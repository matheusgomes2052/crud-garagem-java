import java.util.Scanner;

class Carro{
    static Scanner sc = new Scanner(System.in);
    private String marca;
    private String modelo;
    private int ano;
    private double motor;

    Carro(String marca, String modelo, int ano, double motor){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.motor = motor;
    }

    public String getMarca(){
        return this.marca;
    }
    public void setMarca(){
        System.out.printf("Qual a nova marca do seu carro?(Atual: %s)\n", this.marca);
        this.marca = sc.nextLine();
    }

    public String getModelo(){
        return this.modelo;
    }
    public void setModelo(){
        System.out.printf("Qual o novo modelo do seu carro?(Atual: %s)\n", this.modelo);
        this.modelo = sc.nextLine();
    }

    public int getAno(){
        return this.ano;
    }
    public void setAno(){
        System.out.printf("Qual o novo ano do seu carro?(Atual: %d)\n", this.ano);
        this.ano = Integer.parseInt(sc.nextLine());
    }

    public double getMotor(){
        return this.motor;
    }
    public void setMotor(){
        System.out.printf("Qual o novo motor do seu carro?(Atual: %.1f)\n", this.motor);
        this.motor = Double.parseDouble(sc.nextLine());
    }
}

public class Main {
    static int tamanhoMaximoGaragem = 30;

    static Scanner sc = new Scanner(System.in);
    static int tamanhoGaragem = 0;
    static Carro[] garagem = new Carro[tamanhoMaximoGaragem];

    public static void adicionaCarro() {
        if (tamanhoGaragem < tamanhoMaximoGaragem) {
            String marca, modelo;
            int ano;
            double motor;

            System.out.println("Qual é a marca do seu carro?(Honda, Fiat, Toyota, etc.)");
            marca = sc.nextLine();

            System.out.println("Qual é o modelo do seu carro?(Civic, Palio, Corolla, etc.)");
            modelo = sc.nextLine();

            System.out.println("Qual é o ano do seu carro?");
            ano = Integer.parseInt(sc.nextLine());

            System.out.println("Qual é o motor do seu carro?");
            motor = Double.parseDouble(sc.nextLine());

            Carro carro = new Carro(marca, modelo, ano, motor);

            garagem[tamanhoGaragem] = carro;
            tamanhoGaragem++;

            System.out.println("Seu carro foi criado com sucesso!\n");
            System.out.println("O que deseja fazer agora?");
            mostraOpcoes();
        }else{
            System.out.println("Sua garagem está cheia, delete um carro para adicionar mais!");
        }
    }
    public static void exibeGaragem() {
        if (tamanhoGaragem == 0){
            System.out.println("Você não possui carros em sua garagem!\n");
            System.out.println("O que deseja fazer agora?");
            mostraOpcoes();
        }else{
            System.out.println("Esta é sua garagem atual:");
            for (int i = 0; i < tamanhoGaragem; i++){
                System.out.printf("Carro %d: %s %s %d com motor %.1f\n", (i + 1), garagem[i].getMarca(), garagem[i].getModelo(), garagem[i].getAno(), garagem[i].getMotor());
            }
        }
    }
    public static void deletaCarro(){
        if (tamanhoGaragem > 0) {
            System.out.println("Digite o código do carro que deseja deletar:");
            for (int i = 0; i < tamanhoGaragem; i++) {
                System.out.printf("%d: %s %s %d\n", (i + 1), garagem[i].getMarca(), garagem[i].getModelo(), garagem[i].getAno());
            }
            int numSelecionado;
            numSelecionado = Integer.parseInt(sc.nextLine());
            if (numSelecionado > 0 && numSelecionado <= tamanhoGaragem) {
                for (int i = numSelecionado; i <= tamanhoGaragem; i++) {
                    if (i == tamanhoMaximoGaragem) {
                        garagem[i - 1] = null;
                    } else {
                        garagem[i] = garagem[i + 1];
                    }
                }
                tamanhoGaragem = tamanhoGaragem - 1;
                System.out.println("Carro removido com sucesso!");
            } else {
                System.out.println("Código de carro inválido!");
            }
        }else{
            System.out.println("Você não possui carros para remover!");
        }
    }
    public static void editaCarro(){
        if (tamanhoGaragem > 0) {
            System.out.println("Digite o código do carro que deseja deletar:");
            for (int i = 0; i < tamanhoGaragem; i++) {
                System.out.printf("%d: %s %s %d\n", (i + 1), garagem[i].getMarca(), garagem[i].getModelo(), garagem[i].getAno());
            }
            int numSelecionado;
            numSelecionado = Integer.parseInt(sc.nextLine());
            if (numSelecionado > 0 && numSelecionado <= tamanhoGaragem) {
                System.out.println("Digite o código do que você deseja editar?");
                System.out.println("1-Marca");
                System.out.println("2-Modelo");
                System.out.println("3-Ano");
                System.out.println("4-Motor");
                int editSelecionado = Integer.parseInt(sc.nextLine());
                if (editSelecionado > 0 && editSelecionado <= 4){
                    switch (editSelecionado){
                        case 1:
                            garagem[numSelecionado - 1].setMarca();
                            break;
                        case 2:
                            garagem[numSelecionado - 1].setModelo();
                            break;
                        case 3:
                            garagem[numSelecionado - 1].setAno();
                            break;
                        case 4:
                            garagem[numSelecionado - 1].setMotor();
                            break;
                    }
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("Código inserido inválido");
                }
            } else {
                System.out.println("Código de carro inválido!");
            }
        }else{
            System.out.println("Você não possui carros para editar!");
        }
    }
    public static void chamaEscolha(int num) {
        int[] possibilidades = {1, 2, 3, 4};
        boolean exist = false;
        for(int i : possibilidades){
            if (i == num){
                exist = true;
                break;
            }
        }
        if (exist){
            switch(num){
                case 1:
                    adicionaCarro();
                    break;
                case 2:
                    exibeGaragem();
                    break;
                case 3:
                    deletaCarro();
                    break;
                case 4:
                    editaCarro();
                    break;
            }

            System.out.println("\nEscolha o que deseja fazer:");
            mostraOpcoes();
        }else{
            System.out.println("Número inválido, selecione outra opção!");
            mostraOpcoes();
        }
    }
    public static void mostraOpcoes () {
        int numSelected = 0;
        System.out.println("1-Adicionar carro novo");
        System.out.println("2-Ver sua garagem atual");
        System.out.println("3-Excluir carro");
        System.out.println("4-Editar carro");
        numSelected = Integer.parseInt(sc.nextLine());
        chamaEscolha(numSelected);
    }
    public static void main(String[] args) {
        System.out.println("<==========GARAGEM==========>");
        System.out.println("Seja bem vindo a garagem de carros em Java!");
        System.out.println("O que você deseja fazer por primeiro?");
        mostraOpcoes();
    }
}