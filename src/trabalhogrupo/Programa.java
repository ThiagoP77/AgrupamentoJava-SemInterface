package trabalhogrupo;

import java.lang.Math;//importa a classe Math (realizar raíz quadrada)
import java.util.Scanner;//importa a classe Scanner (inserir dados)
import java.util.ArrayList;//importa a classe ArrayList (criar listas de objetos)
import java.util.Random;//importa a classe Random (escolher números aleatórios)

public class Programa {

    //Grupo: Thiago, Lara, Valentina e Thales.
    
    private static int menu(){
        Scanner scan1 = new Scanner(System.in);//Objeto da classe Scanner para obter a opção do menu que o usuário deseja
        System.out.println("\t\t===============================");//Front-end
        System.out.println("\t\t----- SELECIONE UMA OPÇÃO -----");
        System.out.println("\t\t===============================\n");
        System.out.println("\t➣ Primeira opção: Sair do programa (selecione a tecla 0).");
        System.out.println("\t➣ Segunda opção: Inserir pessoa (selecione a tecla 1).");
        System.out.println("\t➣ Terceira opção: Agrupar pessoas (selecione a tecla 2).\n");
        System.out.print("➢ Insira a tecla correspondente à opção escolhida: ");//Pede a opção ao usuário
        int opcao = scan1.nextInt();//Recebe a opção digitada pelo usuário
        return opcao;//Retorna a opção digitada
    }
    
    public static void main(String[] args) {
        int menuop;//Variável que recebe o valor da "opção" do método "menu()"
        float menordistancia = 0;//Variável que recebe a menor distância euclidiana entre os objetos
        Scanner scani = new Scanner (System.in);//Objeto da classe Scanner para obter int
        Scanner scans = new Scanner (System.in);//Objeto da classe Scanner para obter String
        Scanner scanf = new Scanner (System.in);//Objeto da classe Scanner para obter float
        Random aleatorio = new Random();//Objeto da classe Random para gerar números aleatórios
        ArrayList listap = new ArrayList();//Objeto da classe lista que recebe as pessoas inseridas
        ArrayList listap1 = new ArrayList();//Objeto da classe lista que recebe as pessoas inseridas e não-centróides
        ArrayList listac = new ArrayList();//Objeto da classe lista que recebe os centróides
        ArrayList listag = new ArrayList();//Objeto da classe lista que recebe os não-centróides e centróides já com grupos definidos
        
        do{
            menuop = menu();
            
            if ((menuop<0)||(menuop>2)){//Código para caso o usuário insira uma opção mão disponível
                System.out.println("\n➤ Erro! A opção inserida não está disponível.\n");//Mensagem de erro
            } 
            
            if (menuop == 1){//Código para caso o usuário deseje inserir uma pessoa
                System.out.println("\n\t===== INSIRA OS DADOS SOBRE A PESSOA =====\n");//Front-end
                System.out.print("➢ Nome da pessoa: ");//Pede dado ao usuário
                String n = scans.nextLine();//Recebe o dado do usuário
                System.out.print("➢ Idade da pessoa: ");//Pede dado ao usuário
                int i = scani.nextInt();//Recebe o dado do usuário
                System.out.print("➢ Sexo da pessoa ('0' para masculino e '1' para feminino): ");//Pede dado ao usuário
                int s = scani.nextInt();//Recebe o dado do usuário
                System.out.print("➢ Altura da pessoa: ");//Pede dado ao usuário
                float a = scanf.nextFloat();//Recebe o dado do usuário
                System.out.print("➢ Peso da pessoa: ");//Pede dado ao usuário
                float p = scanf.nextFloat();//Recebe o dado do usuário
                System.out.println(" ");//Front-end
                Pessoa pes = new Pessoa (n, i, s, a, p);//Cria o objeto da classe Pessoa
                
                if (pes.validacao()){//Código para caso os dados da pessoa inserida sejam válidos
                    listap.add(pes);//Adiciona a pessoa à lista
                    System.out.println("➤ Pessoa inserida com sucesso!\n");//Informa ao usuário que a pessoa foi inserida
                    listap1.clear();//Limpa a lista secundária de pessoas
                    
                    for (int l = 0; l < listap.size(); l ++){//A lista secundária recebe todos os objetos da "listap"
                        listap1.add(listap.get(l));//Adiciona um objeto de "listap" à "listap1"
                    }

                } else {//Código para caso os dados da pessoa inserida não sejam válidos
                    System.out.println("➤ Erro, informação inválida inserida!");//Mensagem de erro
                    System.out.println("➤ Retornando ao menu principal.\n");
                }   
            } 
            
            if (menuop == 2){//Código para caso o usuário queira agrupar as pessoas inseridas
                System.out.print("\n➢ Quantos grupos devem ser criados: ");//Pede ao usuário a quantidade de grupos que devem ser criados
                int kk = scani.nextInt();//Variável recebe a quantidade indicada para verificação
                
                if (kk<1||kk>Pessoa.getTotalPessoas()){//Código para caso o usuário insira um valor inválido
                    System.out.println("\n➤ Erro, valor inválido inserido!");
                    System.out.println("➤ Retornando ao menu principal.\n");
                    
                } else if (kk<Pessoa.getTotalPessoas() && kk>0) {//Código para caso o usuário insira um valor adequado e que não seja igual ao número de pessoas.
                    listap1.clear();//Limpa a "listap1" para reincluir todas as pessoas
                    listac.clear();//Limpa a "listac" para incluir apenas os novos centróides
                    
                    for (int l = 0; l < listap.size(); l ++){//A lista secundária recebe todos os objetos da "listap"
                        listap1.add(listap.get(l));//Adiciona um objeto de "listap" à "listap1"
                    }
                    
                    int k = kk;//Váriavel "k" recebe "kk"
                    
                    for (int f = 0; f<k; f++){//Código para escolha de centróides e não-centróides
                        int fk;//Variável para escolher centroides
                        fk = listap1.size();//fk recebe o tamanho de "listap1"
                        int cn = aleatorio.nextInt(fk);//Variável "cn" recebe um número aleatório
                        Pessoa c1;//Cria um objeto Pessoa
                        c1 = (Pessoa)listap1.get(cn);//c1 recebe o objeto da "listap1" correspondente a "cn"
                        listap1.remove(cn);//Remove "cn" da lista de não-centróides
                        listac.add(c1);//Adiciona "cn" à lista de centróides
                    }
                    
                    for (int f2 = 0; f2<listap1.size(); f2++){//Código para verificar distância euclidiana de cada não-centróide
                        for(int f3 =0; f3<listac.size();f3++){//Código que compara cada não-centróide com cada centróide
                            Pessoa p2 = (Pessoa) listap1.get(f2);//p2 recebe o objeto pessoa correspondente à localização f2 na lista 
                            Pessoa c2 = (Pessoa) listac.get(f3);//c2 recebe o objeto pessoa correspondente à localização f3 na lista 
                            c2.setGrupo(f3+1);//Determina o grupo dos centróides
                            int deltaSexo = p2.getSexoI() - c2.getSexoI();//Calcula o deltaSexo entre centróide e não-centróide
                            int deltaIdade = p2.getIdade() - c2.getIdade();//Calcula o deltaIdade entre centróide e não-centróide
                            float deltaPeso = p2.getPeso() - c2.getPeso();//Calcula o deltaPeso entre centróide e não-centróide
                            float deltaAltura = p2.getAltura() - c2.getAltura();//Calcula o deltaAltura entre centróide e não-centróide
                            float deltaGeral = (deltaSexo*deltaSexo) + (deltaIdade*deltaIdade) + (deltaPeso*deltaPeso) + (deltaAltura*deltaAltura);//Calcula o deltaGeral entre centróide e não-centróide
                            float distancia = (float) Math.sqrt(deltaGeral);//Calcula a raíz quadrada do deltaGeral (distância euclidiana)
                            
                            if (f3 == 0){//Código que ocorre na primeira repetição
                                p2.setGrupo(1);//Determina o grupo do não-centróide como 1
                                menordistancia = distancia;//Determina a menor distância euclidiana como a primeira
                                
                            } else if (f3 != 0 && distancia<menordistancia) {//Código que ocorre a partir da segunda repetição e quando a distância for menor
                                menordistancia = distancia;//"menordistancia" recebe a distancia atual
                                p2.setGrupo(f3+1);//Grupo da pessoa muda para a da atual repetição
                            }
                            
                            if (f3+1==listac.size()){//Adiciona o não-centróide à "listag" na última repetição do for interno
                                listag.add(p2);
                            }
                            
                            if (f2+1==listap1.size()){//Adiciona o centróide à "listag" na última repetição do for externo
                                listag.add(c2);
                            }
                        }
                    }
                 
                    System.out.println("\n\t\t======================");//Front-End
                    System.out.println("\t\t----- RESULTADOS -----");
                    System.out.println("\t\t======================\n");
                    
                    for (int f5 =1; f5<(k+1); f5++){//Código para mostrar os resultados
                        for (int f6 = 0; f6<listag.size(); f6++){//Se repete até mostrar todas as pessoas da "listag"
                            Pessoa pf = (Pessoa) listag.get(f6);//"pf" recebe o objeto Pessoa de "listag" correspondente ao f6
                            
                            if(f5==pf.getGrupo()){//Mostra as pessoas em ordem crescente de grupos
                                System.out.println("(Grupo "+pf.getGrupo()+") "+pf.getNome()+ " [Sexo = "+pf.getSexoI()+"] [Idade = "+pf.getIdade()+"] [IMC = "+pf.calculaIMC()+"] "+pf.classificaIMC());                          
                            } 
                        }
                        System.out.println(" ");//Pula espaço entre grupos
                    }
                    
                    listag.clear();//Limpa a "listag" para futuros agrupamentos
                    
                } else if (kk == Pessoa.getTotalPessoas()) {//Código para caso o número de grupos seja o mesmo que o de pessoas
                    
                    listap1.clear();//Limpa a lista de não-centróides
                    listac.clear();//Limpa a lista de centróides
                    
                    for (int l = 0; l < listap.size(); l ++){//A lista secundária recebe todos os objetos da "listap"
                        listap1.add(listap.get(l));//Adiciona um objeto de "listap" à "listap1"
                    }
                    
                    System.out.println("\n\t\t======================");//Front-End
                    System.out.println("\t\t----- RESULTADOS -----");
                    System.out.println("\t\t======================\n");
                    
                    for (int f7 = 0; f7<listap1.size(); f7++){//Código para mostrar os resultados
                        Pessoa pf2 = (Pessoa) listap1.get(f7);//"pf2" recebe o objeto Pessoa de "listap1" correspondente ao f7
                        pf2.setGrupo(f7+1);//Determina o grupo de "pf2"
                        System.out.println("(Grupo "+pf2.getGrupo()+") "+pf2.getNome()+ " [Sexo = "+pf2.getSexoI()+"] [Idade = "+pf2.getIdade()+"] [IMC = "+pf2.calculaIMC()+"] "+pf2.classificaIMC());
                        System.out.println(" ");//Pula linha entre grupos
                    }    
                   }
            }
                
        } while (menuop!=0);//Repete o código até a pessoa digitar "0" (comando para encerramento)
        
        if (menuop == 0){//Código para encerrar o programa
            System.out.println("\n➤ Programa encerrado com sucesso!");
        }
    }
    
}
