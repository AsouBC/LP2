import java.util.ArrayList;
import java.util.Scanner;

//Falta fazer a leitura do arquivo e adicionar os dados na lista e imprimir tudo
//Mas vou enviar assim mesmo, tô com pouco tempo

public class Funcionario{
        protected int id;
        protected String nome, email, senha, cargo, turma;
        protected String setor;

        public Funcionario(int id, String nome, String email, String senha, String cargo){
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.cargo = cargo;
        }
        public String imprimirSenha(String senha){
            String s = "";
            for(int i = 0; i < senha.length(); i++){
                s += "*";
            }
            return s;
        }
        public static void main(String[] args){
            ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
            Scanner ler = new Scanner(System.in);
            int x, y, id, z;
            String nome, email, senha, cargo, turma, setor;

           
            do{
            System.out.println("Qual funcionário quer receber?");
            System.out.println("1 - Com setor e sem turma");
            System.out.println("2 - Com Turma e sem setor");
            System.out.println("3 - Sem nenhum dos dois");
            z = ler.nextInt();
            switch(z){
                case 1: 
                    System.out.println("Qual o id do funcionario?");
                    id = ler.nextInt();
                    ler.nextLine();
                    System.out.println("Qual o nome do funcionario?");
                    nome = ler.nextLine();
                    System.out.println("Qual o email do funcionario?");
                    email = ler.nextLine();
                    System.out.println("Qual a senha do funcionario?");
                    senha = ler.nextLine();
                    System.out.println("Qual o cargo do funcionario?");
                    cargo = ler.nextLine();
                    System.out.println("Qual o setor do funcionario?");
                    setor = ler.nextLine();
                    Funcionario funcionarioSe = new Setor(id, nome, email, senha, cargo, setor);
                    funcionarios.add(funcionarioSe);
                    System.out.println("Funcionario recebido com sucesso!");
                    break;
                case 2: 
                    System.out.println("Qual o id do funcionario?");
                    id = ler.nextInt();
                    ler.nextLine();
                    System.out.println("Qual o nome do funcionario?");
                    nome = ler.nextLine();
                    System.out.println("Qual o email do funcionario?");
                    email = ler.nextLine();
                    System.out.println("Qual a senha do funcionario?");
                    senha = ler.nextLine();
                    System.out.println("Qual o cargo do funcionario?");
                    cargo = ler.nextLine();
                    System.out.println("Qual a turma do funcionario?");
                    turma = ler.nextLine();
                    Funcionario funcionarioTu = new Turma(id, nome, email, senha, cargo, turma);
                    funcionarios.add(funcionarioTu);
                    System.out.println("Funcionario recebido com sucesso!");
                    break;
                case 3: 
                    System.out.println("Qual o id do funcionario?");
                    id = ler.nextInt();
                    ler.nextLine();
                    System.out.println("Qual o nome do funcionario?");
                    nome = ler.nextLine();
                    System.out.println("Qual o email do funcionario?");
                    email = ler.nextLine();
                    System.out.println("Qual a senha do funcionario?");
                    senha = ler.nextLine();
                    System.out.println("Qual o cargo do funcionario?");
                    cargo = ler.nextLine();
                    Funcionario funcionario = new Funcionario(id, nome, email, senha, cargo);
                    funcionarios.add(funcionario);
                    System.out.println("Funcionario recebido com sucesso!\n");
                    break;
                default: 
                    System.out.println("Opção invalida!");
                    break;
            }
            System.out.println("Voce quer receber mais um funcionario? Sim(1) ou Nao(0)\n");
            x = ler.nextInt();
            }while(x == 1);

            //imprimir ArrayList
            for(int i = 0; i < funcionarios.size(); i++){
                System.out.println(funcionarios.get(i));
            }

            System.out.println("\nVoce quer adicionar os dados na lista do arquivo? (1) ou Nao(0)");
            y = ler.nextInt();
        }

        @Override
        public String toString(){
            return "Id: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nSenha: " + imprimirSenha(senha) + "\nCargo: " + cargo;
        }
    }