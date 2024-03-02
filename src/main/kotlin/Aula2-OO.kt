package br.ifpb.pdm

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 4
    while (opcao != 11) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 4
        when (opcao) {
            1 -> {
                adicionarAnimal(repositorioAnimal, "Cachorro");
            }
            2 -> {
                adicionarAnimal(repositorioAnimal, "Gato");
            }
            3 -> {
                adicionarAnimal(repositorioAnimal, "Passaro");
            }
            4 -> {
                adicionarAnimal(repositorioAnimal, "Homem");
            }
            5 -> {
                repositorioAnimal.listar()
            }
            6 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            7 -> {
                println("Digite o nome do animal que deseja excluir:")
                val nome = readlnOrNull()?.toString() ?: "";
                repositorioAnimal.remover(nome);
            }
            8 -> {
                println("Digite a cor dos animais que deseja visualizar:")
                val cor = readlnOrNull()?.toString() ?: "";
                repositorioAnimal.listarCor(cor).forEach{ println(it.nome) }
            }
            9 -> {
                println("Digite a idade dos animais que deseja visualizar:")
                val idade = readlnOrNull()?.toInt() ?: 0;
                repositorioAnimal.listarIdade(idade).forEach{ println(it.nome) }
            }
            10 -> {
                println("Digite o nome do animal que deseja visualizar:")
                val nome = readlnOrNull()?.toString() ?: "";
                val resultado =
                    repositorioAnimal.filtrarNome(nome)?.nome ?:
                    "Animal não existe!";
                println(resultado);
            }
        }

    }
}

fun adicionarAnimal(repositorioAnimal: RepositorioAnimal,
                    tipoAnimal: String) {
    println("Insira o nome do animal que deseja adicionar")
    val nome = readlnOrNull()?.toString() ?: "";
    println("Insira a idade do animal que deseja adicionar")
    val idade = readlnOrNull()?.toInt() ?: 0;
    when (tipoAnimal) {
        "Cachorro" -> {
            val cachorro = Cachorro(idade);
            cachorro.nome = nome;
            repositorioAnimal.adicionar(cachorro)
        }
        "Gato" -> {
            val gato = Gato(idade);
            gato.nome = nome;
            repositorioAnimal.adicionar(gato)
        }
        "Passaro" -> {
            val passaro = Passaro(idade);
            passaro.nome = nome;
            repositorioAnimal.adicionar(passaro)
        }
        "Homem" -> {
            val homem = Homem(idade);
            homem.nome = nome;
            repositorioAnimal.adicionar(homem)
        }
    }
}

abstract class Animal(var idade: Int, var cor: Cor) {
    open var nome: String = ""
        get() = "$field"
        set(valor) {
            field = valor
        }

    abstract fun emitirSom()
    abstract fun idadeEmAnosHumanos()
}

class Homem(idade: Int) : Animal(idade, Cor.VERMELHO) {
    override fun emitirSom() {
        println("Salve")
    }

    override fun idadeEmAnosHumanos() {
        val idadeEmAnosHumanos = idade;
        println(idadeEmAnosHumanos);
    }
}

class Cachorro(idade: Int) : Animal(idade, Cor.VERMELHO) {
    override fun emitirSom() {
        println("Au au")
    }

    override fun idadeEmAnosHumanos() {
        val idadeEmAnosHumanos = idade * 7;
        println(idadeEmAnosHumanos);
    }
}
class Gato(idade: Int) : Animal(idade, Cor.AZUL) {
    override fun emitirSom() {
        println("Miau")
    }
    override fun idadeEmAnosHumanos() {
        val idadeEmAnosHumanos = idade * 7;
        println(idadeEmAnosHumanos);
    }
}

class Passaro(idade: Int) : Animal(idade, Cor.VERDE) {
    override fun emitirSom() {
        println("Piu piu")
    }
    override fun idadeEmAnosHumanos() {
        val idadeEmAnosHumanos = idade * 7;
        println(idadeEmAnosHumanos);
    }
}

fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Homem")
    println("5 - Listar Animais")
    println("6 - Emitir som")
    println("7 - Remover Animal")
    println("8 - Listar por cor")
    println("9 - Listar por idade")
    println("10 - Filtrar por nome")
    println("11 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun remover(nome: String) {
        var index: Int = 0;
        for (i in animais.withIndex()) {
            println("${i.value} ${i.index} $index")
            if (i.value.nome == nome) {
                index = i.index;
            }
        }
        animais.removeAt(index);

    }

    fun filtrarNome(nome: String): Animal? {
        var filtrado: Animal? = null;
        for (animal in animais) {
            if (animal.nome == nome) {
                filtrado = animal
            }
        }
        return filtrado ?: null;
    }

    fun listar() {
        animais.forEach { println(it.nome) }
    }


    fun listarCor(cor: String): MutableList<Animal> {
        var filtrados = mutableListOf<Animal>();
        for (animal in animais) {
            if (animal.cor.cor == cor) {
                filtrados.add(animal);
            }
        }
        return filtrados;
    }

    fun listarIdade(idade: Int): MutableList<Animal> {
        var filtrados = mutableListOf<Animal>();
        for (animal in animais) {
            if (animal.idade == idade) {
                filtrados.add(animal);
            }
        }
        return filtrados;
    }
}

enum class Cor(val cor: String) {
    VERMELHO("vermelho"),
    VERDE("verde"),
    AZUL("azul")
}