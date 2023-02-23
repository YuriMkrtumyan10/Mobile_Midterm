class HTP {
    //Recursive Solution
    fun tower(
        n: Int,
        headRod: Int,
        tailRod: Int,
        middleRod: Int
    ) {
        //base case
        if (n == 0)
            return

        tower(n - 1, headRod, middleRod, tailRod)
        println("Disk number: " + n + " from rod " + headRod + " to rod " + tailRod)
        tower(n - 1, middleRod, tailRod, headRod)
    }

    fun main(args: Array<String>) {
       tower(3, 1, 2, 3)
    }
}