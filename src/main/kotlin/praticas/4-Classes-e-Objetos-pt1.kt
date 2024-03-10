import kotlin.math.sqrt

fun main () {
    main1()
    main2()
    main3()
    main4()
    main5()
}

// Questão 1
class Produto// Implemente os construtores conforme especificado na questão
    () {
    var nome: String
    var preco: Double


    init {
        this.nome = "Produto"
        this.preco = 0.0
    }

    constructor(nome: String) : this() {
        this.nome = nome
        this.preco = 0.0
    }

    constructor(nome: String, preco: Double) : this() {
        this.nome = nome
        this.preco = preco
    }

}

fun main1() {
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    val produto = Produto()
    val chocolate = Produto("Hershey's")
    val kitkat = Produto("Kitkat", 3.55)

    println("Q1")

    println("Produto ${produto.nome} ${produto.preco}")
    println("Produto ${chocolate.nome} ${chocolate.preco}")
    println("Produto ${kitkat.nome} ${kitkat.preco}")
}

// Questão 2
class Cliente {
    var nome: String = ""
    private var idade: Int = 0

    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão

    // Crie um método público na classe Cliente chamado mostrarIdade() conforme especificado na questão
    public fun mostrarIdade() {
        println(this.idade)
    }
}

fun main2() {
    // Crie uma instância de Cliente e chame o método mostrarIdade() para verificar seu funcionamento.
    val cli1 = Cliente()
    println("Q2")
    cli1.mostrarIdade();
}

// Questão 3
abstract class Personagem {
    // Crie um método abstrato atacar() conforme especificado na questão
    abstract fun atacar()
}

class Guerreiro : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Guerreiro
        println("O guerreiro ataca com uma espada!")
    }
}

class Mago : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Mago
        println("O mago conjura Firaga!")
    }
}

fun main3() {
    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
    val guerreiro = Guerreiro()
    val mago = Mago()
    println("Q3")
    guerreiro.atacar()
    mago.atacar()
}

// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
    abstract fun calcularArea(): Double
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Retangulo conforme especificado na questão
        return altura*largura
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Circulo conforme especificado na questão
        return Math.PI * (raio*raio)
    }
}

fun main4() {
    // Crie instâncias dessas duas classes e chame o método calcularArea() em cada uma delas para verificar o resultado.
    val circulo = Circulo(5.0)
    val retangulo = Retangulo(5.0, 8.0)
    println("Q4")
    println(circulo.calcularArea())
    println(retangulo.calcularArea())
}

// Questão 5
class ContaBancaria() {
    var numeroConta: String = ""
    var nomeTitular: String = ""
        get() {
            return "${field[0].uppercase()}${field.substring(1)}"
        }
    var saldo: Double = 0.0
        set(value) {
            if (value < 0.0) field = 0.0
            else field = value
        }

    // Implemente um getter personalizado para a propriedade nomeTitular conforme especificado na questão

    // Implemente override do setter para o atributo saldo conforme especificado na questão
}

fun main5() {
    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
    val conta = ContaBancaria()
    conta.nomeTitular = "pablo"
    conta.saldo = -155.5
    println("Q5")
    println(conta.nomeTitular)
    println(conta.saldo)
}
