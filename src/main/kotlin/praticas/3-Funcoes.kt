/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double>): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 * 
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 * 
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }
        }
        else{
            println("Não foi possível mostrar as notas da matéria ${materia}")
        }

        println()
    }


}

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(){ }


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia:String, vararg nota:Double){}


fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("PDM", mutableListOf(9.8, 10.0, 8.2, 7.1));

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia="PWEB2", notas= mutableListOf(8.8, 9.1, 8.1, 9.9));

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
        return materiasENotas.put(materia, notas) != null
    }

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina(materia="Estatistica");

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("Estatistica", 8.9);
    
    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("PDM");
    mostrarNotas("PWEB2");
    mostrarNotas("Estatistica");
    
    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("BD2");
    
    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    fun adicionarVariasNotas(materia:String, vararg notas:Double): Boolean {
        val materiaAlvo = materiasENotas[materia] ?: return false
        notas.forEach { materiaAlvo.add(it) }
        return true
    }
    
    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("BD2", 9.9, 9.8, 5.8, 8.8);
    
    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("BD2")
    
    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)
    
    // 11: calcularMedia -> Implemente a função calcularMedia()
    fun calcularMedia(materia: String): Any {
        val materiaAlvo = materiasENotas[materia] ?: return false
        if (materiaAlvo.size == 0) return false;
        var soma = 0.0
        materiaAlvo.forEach { soma += it }
        return soma / materiaAlvo.size;
    }
    
    // 12: calcularMedia -> calcule a media de 2 disciplinas
    println(calcularMedia("BD2"))
    println(calcularMedia("PDM"))
    
    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    fun mostrarNotas(materia:String){

        if(!materiasENotas.containsKey(materia)){
            println("Materia $materia não encontrada")
        }
        else{
            val listaNotas = materiasENotas[materia]

            if (listaNotas != null) {
                var cont = 1
                for(nota:Double in listaNotas){
                    println("Nota ${cont++}: $nota")
                }
            }
            else{
                println("Não foi possível mostrar as notas da matéria ${materia}")
            }

            println()
            println("Média : ${calcularMedia(materia=materia)}")
        }


    }
    
    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    mostrarNotas("BD2")

}