// has errors here but the logic is without recursive
class HTP2 {
    fun main(args: Array<String>) {
        tower(3)
    }
    fun tower(n: Int) {
        val headRod = mutableListOf<Int>()
        val middleRod = mutableListOf<Int>()
        val tailRod = mutableListOf<Int>()

        for (i in n downTo 1) {
            headRod.add(i)
        }

        // as the problem was described the total number of moves is 2^n - 1
        val totalMoves = Math.pow(2.0, n.toDouble()).toInt() - 1

        var from = headRod
        var to = tailRod
        for (i in 1..totalMoves) {

                if(i % 3 == 1){
                    to = middleRod
                }else if (i % 3 == 2){
                    to = tailRod
                }else if(i % 3 == 0){
                    to = headRod
                }


            if (i % 2 == 1) {
                moveDisk(from, to)
            } else {
                moveDisk(to, from)
            }

            if (from == headRod) {
                if (to == middleRod) {
                    from = middleRod
                } else {
                    from = tailRod
                }
            } else if (from == middleRod) {
                if (to == headRod) {
                    from = headRod
                } else {
                    from = tailRod
                }
            } else {
                if (to == headRod) {
                    from = headRod
                } else {
                    from = middleRod
                }
            }
        }
    }

    fun moveDisk(from: MutableList<Int>, to: MutableList<Int>) {
        to.add(from.removeAt(from.lastIndex))
        println("Disk number ${from.removeAt(from.lastIndex)} from $from to $to")
    }


}