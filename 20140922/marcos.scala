	object Solution extends App {

		if (args.length == 0) {
			println("Please provide a filename as an argument")
			sys.exit
		}

		val filename = args(0)
		println(filename)

		val source = scala.io.Source.fromFile(filename)
		val lines = source.getLines
		val data = lines.toArray.take(2)
		source.close()


		val firstEquation  = data(0)
		val secondEquation = data(1)

		val eqnRegex = """y=(\d)x([+-]\d)""".r

		val eqnRegex(m1, b1) = firstEquation 
		val eqnRegex(m2, b2) = secondEquation 

		val x = (b2.toInt - b1.toInt).toDouble / (m1.toInt - m2.toInt)
		val y = (m1.toInt * x) + b1.toInt


		println(Tuple2(x,y))

	}
