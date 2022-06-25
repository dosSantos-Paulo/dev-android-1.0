const val desvalorizacaVolksWagen = 0.16
const val desvalorizacaoChevrolet = 0.18
const val desvalorizacaoFiat = 0.20
const val desvalorizacaoRenault = 0.20
const val desvalorizacaoCirtoen = 0.22
const val desvalorizacaoOutros = 0.20

const val anoAtual = 2022

fun main() {
    var textoDoUsuario: String? = ""

    println()
    println("===========================================")
    println("=           Calculaora de vendas          =")
    println("===========================================")
    println()

    do {
        opcoes()
        println()

        print("Digite aqui: ")
        textoDoUsuario = readLine()

        if (textoDoUsuario.equals("calculadora", ignoreCase = true)) {
            calculadora()
        } else {
            println("Você digitou algo inválido")
        }
    } while (!textoDoUsuario.equals("sair", ignoreCase = true))

    println("Encerrou o processo. Boas vendas!!!")
}

fun opcoes() {
    println(":: Opções ::")
    println("Calculadora")
    println("Sair")
}

fun calculadora() {
    print("Digite o modelo: ")
    val modeloDoVeiculo = readLine()
    val marcaDoVeículo = capturandoAMarca()
    val anoDoVeículo = capturarAno()
    val valorDoVeiculoZero = capturaValorDoVeiculo()
    calcularDepreciacao(modeloDoVeiculo, marcaDoVeículo, anoDoVeículo, valorDoVeiculoZero)
}

fun calcularDepreciacao(modelo: String?, marca: String?, ano: Int, valorZeroKm: Int) {
    var porcetagemDeDepreciacao = 0.0

    when (marca) {
        "VolksWagen" -> porcetagemDeDepreciacao = desvalorizacaVolksWagen
        "Chevrolet" -> porcetagemDeDepreciacao = desvalorizacaoChevrolet
        "Fiat" -> porcetagemDeDepreciacao = desvalorizacaoFiat
        "Renault" -> porcetagemDeDepreciacao = desvalorizacaoRenault
        "Citroen" -> porcetagemDeDepreciacao = desvalorizacaoCirtoen
        "Outros" -> porcetagemDeDepreciacao = desvalorizacaoOutros
    }

    val idadeDoCarro = anoAtual - ano
    var novoValorDoCarro = valorZeroKm.toDouble()

    for (i in 1..idadeDoCarro) {
        var depreciacaoDe = novoValorDoCarro * porcetagemDeDepreciacao
        novoValorDoCarro -= depreciacaoDe
    }

    println("Você deve vender o carro por...")
    println()
    println("R$ ${novoValorDoCarro.toInt()}")
    println()
}

fun capturaValorDoVeiculo(): Int {
    var usuarioDigitou = false
    var respostaDoUsuario: String? = ""
    var valorDoCarro = 0
    do {
        print("Digite o valor do veículo (Somente números)")
        respostaDoUsuario = readLine()
        try {
            valorDoCarro = respostaDoUsuario?.toInt()!!
            usuarioDigitou = true
        } catch (ex: java.lang.Exception) {
           println("Digite um valor válido")
        }
    } while (!usuarioDigitou)

    return valorDoCarro
}

fun capturarAno(): Int {
    var usuarioDigitou = false
    var respostaDoUsuario: String? = ""
    var anoDeFabricacao = 0
    do {
        print("Digite o ano de fabricação: ")
        respostaDoUsuario = readLine()
        if (respostaDoUsuario?.length == 4) {
            try {
                anoDeFabricacao = respostaDoUsuario.toInt()
                usuarioDigitou = true
            } catch (ex: java.lang.Exception) {
                println("Digite o ano com 4 dígitos: ")
            }
        } else {
            println("Digite o ano com 4 dígitos")
        }
    } while (!usuarioDigitou)

    return anoDeFabricacao
}

fun capturandoAMarca(): String? {
    var usuarioDigitou = false
    var respostaDoUsuario: String? = ""
    println("Para a marca, digite apenas o número")
    do {
        println(":: Opções de marca ::")
        println("VolksWagen - 1")
        println("Chevrolet - 2")
        println("Fiat - 3")
        println("Renault - 4")
        println("Citroen - 5")
        println("Outros - 6")
        println("Qual a marca: ")
        respostaDoUsuario = readLine()
        when (respostaDoUsuario) {
            "1" -> {
                usuarioDigitou = true
                respostaDoUsuario = "VolksWagen"
            }
            "2" -> {
                usuarioDigitou = true
                respostaDoUsuario = "Chevrolet"
            }
            "3" -> {
                usuarioDigitou = true
                respostaDoUsuario = "Fiat"
            }
            "4" -> {
                usuarioDigitou = true
                respostaDoUsuario = "Renault"
            }
            "5" -> {
                usuarioDigitou = true
                respostaDoUsuario = "Citroen"
            }
            "6" -> {
                usuarioDigitou = true
                respostaDoUsuario = "Outros"
            }
            else -> {
                println("Digite um número válido")
                usuarioDigitou = false
            }
        }

    } while (!usuarioDigitou)

    return respostaDoUsuario

}