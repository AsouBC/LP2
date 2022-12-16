import java.util.Scanner;

class Aluno{
    int matricula, grupo, subTurma;
    String nome, senha;

    public Aluno(int matriculaNova, String nomeNovo, int grupoNovo, int subTurmaNova, String senhaNova){
        matricula = matriculaNova;
        nome = nomeNovo;
        grupo = grupoNovo;
        subTurma = subTurmaNova;
        senha = senhaNova;
    }

    public void ImprimirSenha(String senha){
        for(int i = 0; i < senha.length(); i++){
            System.out.print("*");
        }
    }

    public void MostrarAluno(){
        System.out.println("Matricula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Grupo: " + grupo);
        System.out.println("SubTurma: " + subTurma);
        System.out.println("Senha: ");
        ImprimirSenha(senha);
    }
}

public class Exercicio1a{
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        int matricula, grupo, subTurma;
        String nome, senha;

        Aluno[] novoAluno = new Aluno[3];

        int contadorAlunos = 1;

        for(int i = 0; i < 3; i++){

            System.out.println("Informações do aluno " + contadorAlunos);
            System.out.println("Digite a matricula do aluno: ");
            matricula = ler.nextInt();
            System.out.println("Digite o nome do aluno");
            nome = ler.next();
            System.out.println("Digite o grupo do aluno");
            grupo = ler.nextInt();
            System.out.println("Digite a subturma do aluno");
            subTurma = ler.nextInt();
            System.out.println("Digite a senha do aluno: ");
            senha = ler.next();

            contadorAlunos++;

            novoAluno[i] = new Aluno(matricula, nome, grupo, subTurma, senha);
        }
        int contadorA = 1;
        for(int i = 0; i < 3; i++){
            System.out.println("\n|||||||||||||||||||||||");
            System.out.println("Aluno " + contadorA);
            novoAluno[i].MostrarAluno();
            System.out.println("\n|||||||||||||||||||||||");
            contadorA++;
        }
    }
}