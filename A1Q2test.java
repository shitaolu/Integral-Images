package A1Q2;

public class A1Q2test {
	public static void main(String[] args) {
        int[][] image1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] image2 = {{7, 6}, {1}, {9, 11, 3}};
        int[][] image3 = {};
        int top,bottom,left,right;
        double mean;
        
        long startTime = System.nanoTime();        
        int[] marks = new int[7];
        int nCorrect = 0;

        IntegralImage integralImage1;
        top = 1;
        bottom = 2;
        left = 0;
        right = 1;

       try {
            integralImage1 = new IntegralImage(image1);
        } catch (InvalidImageException iix) {
            System.out.println("Invalid Image Exception");
            return;
        }
        //test case 1//
        System.out.println("Test case 1:");
        try {
            mean = integralImage1.meanSubImage(top, bottom, left, right);
            if (mean == 6.0) { //answer should be 6.0
                System.out.println("Correct");
                marks[1] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The mean of the subimage from (" + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
        } catch (BoundaryViolationException bvx) {
            System.out.println("Incorrect:  Index out of range exception.");
        } catch (NullSubImageException nsix) {
            System.out.println("Incorrect:  Null sub-image exception.");
        }
	catch (ArrayIndexOutOfBoundsException abx) {
            System.out.println("Incorrect:  Array index out of bounds exception.");
        }

        //test case 2//
       System.out.println("Test case 2:");
        top = 0;
        bottom = 1;
        left = 0;
        right = 2;

        try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); 
            if (mean == 3.5) { //answer should be 3.5
                System.out.println("Correct");
                marks[2] = 1;
            } else {
                System.out.println("Incorrect");
            }
           System.out.println("The mean of the subimage from (" + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
        } catch (BoundaryViolationException bvx) {
            System.out.println("Incorrect:  Index out of range exception.");
         } catch (NullSubImageException nsix) {
            System.out.println("Incorrect:  Null sub-image exception.");
        }
	catch (ArrayIndexOutOfBoundsException abx) {
            System.out.println("Incorrect:  Array index out of bounds exception.");
        }

        // test case 3//
        System.out.println("Test case 3:");
        top = 1;
        bottom = 2;
        left = 2;
        right = 1;

        try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); //should throw exception
            System.out.println("Incorrect:  should throw a null sub-image exception");
        } catch (BoundaryViolationException bvx) {
            System.out.println("Incorrect:  Index out of range.");
        } catch (NullSubImageException nsix) {
            System.out.println("Correct:  Null sub-image.");
            marks[3] = 1;
        }
	catch (ArrayIndexOutOfBoundsException abx) {
            System.out.println("Incorrect:  Array index out of bounds exception.");
        }

        // test case 4//
       System.out.println("Test case 4:");
        top = 5;
        bottom = 7;
        left = 6;
        right = 8;

        try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); // should throw exception
            System.out.println("Incorrect:  should throw a boundary violation exception");
        } catch (BoundaryViolationException bvx) {
            System.out.println("Correct:  Index out of range.");
            marks[4] = 1;
        } catch (NullSubImageException nsix) {
            System.out.println("Incorrect: Null sub-image.");
        }
	catch (ArrayIndexOutOfBoundsException abx) {
            System.out.println("Incorrect:  Array index out of bounds exception.");
        }


        // test case 5//
       System.out.println("Test case 5:");
        top = -5;
        bottom = 7;
        left = -6;
        right = 8;

         try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); // should throw exception
            System.out.println("Incorrect:  should throw a boundary violation exception");
        } catch (BoundaryViolationException bvx) {
            System.out.println("Correct:  Index out of range.");
            marks[5] = 1;
        } catch (NullSubImageException nsix) {
            System.out.println("Incorrect: Null sub-image.");
        }
	catch (ArrayIndexOutOfBoundsException abx) {
            System.out.println("Incorrect:  Array index out of bounds exception.");
        }

        // test case 6//
       System.out.println("Test case 6:");
        try {
            integralImage1 = new IntegralImage(image2); //should throw exception
        } catch (InvalidImageException iix) {
            System.out.println("Correct:  Invalid Image Exception");
            marks[6] = 1;
        }
	catch (ArrayIndexOutOfBoundsException abx) {
            System.out.println("Incorrect:  Array index out of bounds exception.");
        }

        long stopTime = System.nanoTime();
        double elapsedTime = (double) (stopTime - startTime) / 1000000; //in msec
        System.out.println("Execution Time (msec): " + elapsedTime);


        System.out.print("Test Case Summary: ");
        for (int i = 1; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
            nCorrect += marks[i];
        }
        System.out.println();
        System.out.println("Test Case Grade: " + (double) nCorrect / (marks.length - 1));

    }
}
