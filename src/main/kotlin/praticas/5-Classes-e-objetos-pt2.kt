/** SISTEMA DE REGISTROS DE FUNCIONÁRIOS
 *
 * Desenvolva um sistema de registro de funcionários para uma empresa.
 * O sistema deverá permitir registrar diferentes tipos de funcionários e apresentar suas informações.
 *
 * Alguns passos abaixo:
 *
 * 1.Crie uma classe base chamada Funcionario com as seguintes propriedades:
 * - Nome (string): o nome do funcionário.
 * - Idade (int): a idade do funcionário.
 **/
open class Funcionario(val nome: String, val idade: Int) {

    /**
     * 5.Imprima uma mensagem informando que um novo funcionário foi registrado, juntamente com o nome e a idade do
     * funcionário. (Lembre-se do init)
     **/
    init {
        println("Novo funcionário ${nome} idade ${idade} registrado.")
    }


    /**
     * 6. Crie um método na classe Funcionario chamado Apresentar que imprima uma mensagem de apresentação do funcionário,
     * incluindo o nome e a idade.
     **/
    open fun apresentar () {
        println("Olá, sou ${this.nome}, e tenho ${this.idade} anos.")
    }
}
/**
 * 2.Crie uma classe Gerente que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Setor (string): o setor em que o gerente trabalha.
 **/

class Gerente (val setor:String, nome: String, idade: Int): Funcionario(nome, idade) {
    override fun apresentar() {
        println("Olá, sou gerente do ${this.setor}, ${this.nome}, e tenho ${this.idade} anos.")
    }
}

/**
 *
 * 3.Crie uma classe Desenvolvedor que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Linguagem (string): a linguagem de programação que o desenvolvedor utiliza.
 **/

class Desenvolvedor(val linguagem: String, nome: String, idade: Int): Funcionario(nome, idade) {
    override fun apresentar() {
        println("Olá, sou desenvolvedor ${this.linguagem}, ${this.nome}, e tenho ${this.idade} anos.")
    }
}

/**
 * 4.Crie uma classe Analista que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Area (string): a área de especialização do analista.
 **/

class Analista(val area: String, nome: String, idade: Int): Funcionario(nome, idade) {
    override fun apresentar() {
        println("Olá, sou analista de ${this.area}, ${this.nome}, e tenho ${this.idade} anos.")
    }
}



fun main() {
    /**
     * 7. Crie uma lista de funcionários e adicione diferentes tipos de funcionários (gerentes, desenvolvedores e analistas)
     * à lista.
     **/
    var f1 = Funcionario("Pedro",32)
    var f2 = Gerente("RH", "Augusto", 45)
    var f3 = Desenvolvedor("Python", "Miguel", 21)
    var f4 = Analista("Requisitos", "Alex", 26)
    var funcionarios = mutableListOf<Funcionario>(f1,f2,f3,f4)
    println(funcionarios)

    /**
     * 8. Utilize o typecast (is e as) para verificar o tipo de cada funcionário na lista e chamar o método Apresentar
     * correspondente.
     */
    funcionarios.forEach {
        it.apresentar()
        when (it) {
            is Gerente -> println("Esse cara é gerente")
            is Desenvolvedor -> println("Esse cara é desenvolvedor")
            is Analista -> println("Esse cara é analista")
            else -> println("Esse cara é funcionário")
        }
    }

}