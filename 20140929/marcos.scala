object Solution extends App {

	if (args.length == 0) {
		println("Please provide a filename as an argument")
		sys.exit
	}

	val filename = args(0)

	val source = scala.io.Source.fromFile(filename)
	val lines = source.getLines
	val dataRE = """(\d+) (\d+) (\d+)""".r
	val data_arr = lines.toArray
	val column_data = data_arr.head
	val dataRE(cols, col_width, space_width) = column_data
	val text_data = data_arr.tail.mkString
	source.close()

	var i = 0;

	for (s <- text_data.grouped(col_width.toInt)) {
		print(s)
		print(" " * space_width.toInt)
		i = i+1;
		if (i % cols.toInt == 0) println 
	}

}
