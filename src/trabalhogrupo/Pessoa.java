package trabalhogrupo;


public class Pessoa {//Classe para receber as pessoas inseridas
    private int validar;//Atributo de validação do objeto
    private String nome;//Atributo para o nome
    private int sexo;//Atributo para o sexo
    private float altura;//Atributo para a altura
    private float peso;//Atributo para o peso
    private int idade;//Atributo para a idade
    private int grupo;//Atributo para o grupo
    private static int numeroPessoas = 0;//Atributo estático com o número de pessoas criadas

    public String getNome() {//Método para retornar o atributo nome do objeto
        return this.nome;
    }
    
    public int getSexoI() {//Método para retornar o atributo sexo do objeto
        return this.sexo;
    }

    public float getAltura() {//Método para retornar o atributo altura do objeto
        return this.altura;
    }


    public void setAltura(float altura) {//Método para modificar e validar a altura do objeto
        if (altura>0 && altura<3){
            this.altura = altura;
        }
    }

    public float getPeso() {//Método para retornar o atributo peso do objeto
        return peso;
    }

    public void setPeso(float peso) {//Método para modificar e validar o peso do objeto
        if (peso>0 && peso<500){
           this.peso = peso;
        }
    }

    public int getIdade() {//Método para retornar o atributo idade do objeto
        return idade;
    }

    public void setIdade(int idade) {//Método para modificar e validar a idade do objeto
        if (idade>0 && idade<150){
            this.idade = idade;
        }
    }
    
    public Pessoa (String n, int i, int s, float a, float p){//Método construtor de Pessoa
        this.validar = 0;//Variável para validar o objeto criado
        if (!n.isEmpty()){//Verifica se o nome está vazio
            this.nome = n;//"nome" recebe "n"
            this.validar++;//Adiciona 1 à "validar"
        }
        if (i>0 && i<150){//Verifica se a idade é válida
            this.idade = i;//"idade" recebe "i"
            this.validar++;//Adiciona 1 à "validar"
        }
        if (s==0 || s==1){//Verifica se o sexo é válido
            this.sexo = s;//"sexo" recebe "s"
            this.validar++;//Adiciona 1 à "validar"
        }
        if (a>0 && a<3){//Verifica se a altura é válida
            this.altura = a;//"altura" recebe "a"
            this.validar++;//Adiciona 1 à "validar"
        }
        if (p>0 && p<500){//Verifica se o peso é válido
           this.peso = p;//"peso" recebe "p"
           this.validar++;//Adiciona 1 à "validar"
        }
        if (this.validar==5){//Verifica se todos os atributos são válidos
            numeroPessoas++;//Adiciona 1 ao total de pessoas
        }
    }
    
    public float calculaIMC(){//Método que realiza o cálculo de IMC
        return (this.getPeso()/(this.getAltura()*this.getAltura()));
    }
    
    public String classificaIMC(){//Método que classifica o IMC
        if(this.calculaIMC()<18.5){
            return "[Peso abaixo do normal!]";
        }else if (this.calculaIMC()>=18.5 && this.calculaIMC()<25){
            return "[Peso normal!]";
        }else if (this.calculaIMC()>=25 && this.calculaIMC()<30){
            return "[Sobrepeso!]";
        }else if (this.calculaIMC()>=30 && this.calculaIMC()<35){
            return "[Obesidade Grau 1!]";
        }else if (this.calculaIMC()>=35 && this.calculaIMC()<40){
            return "[Obesidade Grau 2!]";
        } else {
            return "[Obesidade Mórbida!]";
        }
    }
    
    public boolean validacao(){//Método para verificar validação do objeto Pessoa criado
        if (this.validar == 5){//Retorna "true" se todos os atributos forem válidos
            return true;
        } else {//Retorna "false" se algum atributo for inválido
            return false;
        }
    }
    
    public static int getTotalPessoas(){//Método para obter o total de objetos Pessoa (somente os válidos)
        return numeroPessoas;
    }

    public int getGrupo() {//Método para obter o grupo do objeto Pessoa
        return grupo;
    }

    public void setGrupo(int grupo) {//Método para definir o grupo do objeto Pessoa
        this.grupo = grupo;
    }
    
    
}
