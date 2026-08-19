# schoolutils

A reusable Java package of helper functions for school projects. Import any class
into your program and call its static methods.

## How to use

1. Copy the `schoolutils` folder so it sits next to your source files (or on the classpath).
2. Add an import at the top of your `.java` file:

```java
import schoolutils.MathUtils;
import schoolutils.StringUtils;
```

3. Call the functions directly:

```java
int total = MathUtils.add(5, 3);
boolean prime = MathUtils.isPrime(7);
String rev = StringUtils.reverse("hello");
```

All methods are `static`, so no object needs to be created.

---

## MathUtils

Arithmetic, number theory, and math helpers.

| Method | Description |
|--------|-------------|
| `int add(int a, int b)` | Adds two integers. |
| `double add(double a, double b)` | Adds two doubles. |
| `int subtract(int a, int b)` | Subtracts `b` from `a`. |
| `int multiply(int a, int b)` | Multiplies two integers. |
| `double divide(double a, double b)` | Divides `a` by `b` (returns `NaN` if `b` is 0). |
| `int modulus(int a, int b)` | Returns `a % b`. |
| `int power(int base, int exp)` | Returns `base` raised to `exp`. |
| `int square(int n)` | Returns `n * n`. |
| `int cube(int n)` | Returns `n * n * n`. |
| `int absolute(int n)` | Absolute value of an int. |
| `double absolute(double n)` | Absolute value of a double. |
| `int max(int a, int b)` | Larger of two ints. |
| `int min(int a, int b)` | Smaller of two ints. |
| `boolean isEven(int n)` | True if `n` is even. |
| `boolean isOdd(int n)` | True if `n` is odd. |
| `boolean isPrime(int n)` | True if `n` is prime. |
| `int factorial(int n)` | Factorial of `n`. |
| `int gcd(int a, int b)` | Greatest common divisor. |
| `int lcm(int a, int b)` | Least common multiple. |
| `int sumUpTo(int n)` | Sum of 1..n. |
| `int sumRange(int start, int end)` | Sum of `start`..`end`. |
| `boolean isPerfectSquare(int n)` | True if `n` is a perfect square. |
| `int roundToInt(double n)` | Rounds a double to nearest int. |
| `double toDegrees(double radians)` | Converts radians to degrees. |
| `double toRadians(double degrees)` | Converts degrees to radians. |
| `double squareRoot(double n)` | Square root of `n`. |
| `double log10(double n)` | Base-10 logarithm. |
| `double naturalLog(double n)` | Natural logarithm. |
| `int clamp(int value, int min, int max)` | Clamps `value` into `[min, max]`. |

---

## StringUtils

Text manipulation helpers.

| Method | Description |
|--------|-------------|
| `String toUpperCase(String s)` | Converts to uppercase. |
| `String toLowerCase(String s)` | Converts to lowercase. |
| `boolean equalsIgnoreCase(String a, String b)` | Case-insensitive equality. |
| `boolean contains(String a, String b)` | Case-insensitive contains. |
| `int length(String s)` | Length of the string. |
| `String reverse(String s)` | Reverses the string. |
| `boolean isPalindrome(String s)` | True if the string is a palindrome. |
| `String trimSpaces(String s)` | Trims leading/trailing spaces. |
| `int countWords(String s)` | Counts words separated by whitespace. |
| `String capitalize(String s)` | Capitalizes the first letter. |
| `int countVowels(String s)` | Counts vowels. |
| `int countConsonants(String s)` | Counts consonants. |
| `boolean isEmpty(String s)` | True if null or empty. |
| `String repeat(String s, int times)` | Repeats the string `times` times. |
| `String padLeft(String s, int length)` | Left-pads with spaces. |
| `String padRight(String s, int length)` | Right-pads with spaces. |
| `String replaceAll(String s, String find, String replace)` | Replaces all occurrences. |
| `String firstLetter(String s)` | Returns the first character. |
| `String lastLetter(String s)` | Returns the last character. |
| `String substring(String s, int start, int end)` | Substring from `start` to `end`. |
| `String removeSpaces(String s)` | Removes all spaces. |
| `String initials(String fullName)` | Returns uppercase initials. |

---

## ArrayUtils

Operations on `int` and `double` arrays.

| Method | Description |
|--------|-------------|
| `int sum(int[] arr)` | Sum of all elements. |
| `int max(int[] arr)` | Largest element. |
| `int min(int[] arr)` | Smallest element. |
| `double average(int[] arr)` | Average of elements. |
| `boolean contains(int[] arr, int value)` | True if value is present. |
| `int indexOf(int[] arr, int value)` | Index of value, or -1. |
| `int[] reverse(int[] arr)` | Returns a reversed copy. |
| `void print(int[] arr)` | Prints the array to console. |
| `boolean isSortedAscending(int[] arr)` | True if sorted ascending. |
| `int[] evenNumbers(int[] arr)` | Returns only even numbers. |
| `int[] oddNumbers(int[] arr)` | Returns only odd numbers. |
| `String join(int[] arr, String sep)` | Joins elements with a separator. |
| `int secondLargest(int[] arr)` | Second largest element. |
| `int countOccurrences(int[] arr, int value)` | Counts occurrences of value. |
| `int[] generateSequence(int start, int end)` | Sequence `start`..`end`. |
| `double sum(double[] arr)` | Sum of a double array. |

---

## GradeUtils

Grading and score helpers.

| Method | Description |
|--------|-------------|
| `double computeAverage(double[] scores)` | Average of scores. |
| `String letterGrade(double score)` | A/B/C/D/F from score. |
| `String remark(double score)` | Text remark for a score. |
| `boolean isPassing(double score)` | True if score >= 60. |
| `double percentage(double earned, double total)` | Percentage earned of total. |
| `double weightedAverage(double[] scores, double[] weights)` | Weighted average. |
| `double highest(double[] scores)` | Highest score. |
| `double lowest(double[] scores)` | Lowest score. |
| `int countFailing(double[] scores)` | Count of scores below 60. |
| `String gradeRange(double score)` | Range band (e.g. "90-100"). |

---

## ConversionUtils

Unit conversions.

| Method | Description |
|--------|-------------|
| `double celsiusToFahrenheit(double c)` | °C to °F. |
| `double fahrenheitToCelsius(double f)` | °F to °C. |
| `double kilometersToMiles(double km)` | km to miles. |
| `double milesToKilometers(double mi)` | miles to km. |
| `double metersToFeet(double m)` | m to feet. |
| `double feetToMeters(double ft)` | feet to m. |
| `double kilogramsToPounds(double kg)` | kg to lb. |
| `double poundsToKilograms(double lb)` | lb to kg. |
| `double gramsToOunces(double g)` | g to oz. |
| `double ouncesToGrams(double oz)` | oz to g. |
| `double litersToGallons(double l)` | L to gal. |
| `double gallonsToLiters(double gal)` | gal to L. |
| `double minutesToSeconds(double min)` | min to sec. |
| `double secondsToMinutes(double sec)` | sec to min. |
| `double hoursToMinutes(double h)` | h to min. |
| `double minutesToHours(double min)` | min to h. |
| `double daysToHours(double d)` | days to hours. |
| `double bytesToKilobytes(double b)` | bytes to KB. |
| `double kilobytesToMegabytes(double kb)` | KB to MB. |

---

## StatsUtils

Basic statistics.

| Method | Description |
|--------|-------------|
| `double mean(double[] data)` | Arithmetic mean. |
| `double median(double[] data)` | Median value. |
| `double variance(double[] data)` | Population variance. |
| `double standardDeviation(double[] data)` | Standard deviation. |
| `double range(double[] data)` | Max minus min. |
| `double mode(double[] data)` | Most frequent value. |
| `double geometricMean(double[] data)` | Geometric mean. |
| `double sumOfSquares(double[] data)` | Sum of squares. |
| `double percentile(double[] data, double p)` | p-th percentile. |
| `double coefficientOfVariation(double[] data)` | CV as a percentage. |

---

## Intermediate Utilities

These classes cover geometry, finance, physics, text analysis, number theory,
probability, matrices, and randomness (~95 functions).

### GeometryUtils

| Method | Description |
|--------|-------------|
| `double circleArea(double r)` | Area of a circle. |
| `double circleCircumference(double r)` | Circumference of a circle. |
| `double rectangleArea(double w, double h)` | Area of a rectangle. |
| `double rectanglePerimeter(double w, double h)` | Perimeter of a rectangle. |
| `double triangleArea(double b, double h)` | Area of a triangle. |
| `double squareArea(double s)` | Area of a square. |
| `double squarePerimeter(double s)` | Perimeter of a square. |
| `double trapezoidArea(double a, double b, double h)` | Area of a trapezoid. |
| `double parallelogramArea(double b, double h)` | Area of a parallelogram. |
| `double rhombusArea(double d1, double d2)` | Area of a rhombus. |
| `double ellipseArea(double a, double b)` | Area of an ellipse. |
| `double sphereVolume(double r)` | Volume of a sphere. |
| `double sphereSurfaceArea(double r)` | Surface area of a sphere. |
| `double cylinderVolume(double r, double h)` | Volume of a cylinder. |
| `double cylinderSurfaceArea(double r, double h)` | Surface area of a cylinder. |
| `double coneVolume(double r, double h)` | Volume of a cone. |
| `double cubeVolume(double s)` | Volume of a cube. |
| `double cubeSurfaceArea(double s)` | Surface area of a cube. |

### FinanceUtils

| Method | Description |
|--------|-------------|
| `double simpleInterest(double p, double r, double y)` | Simple interest. |
| `double compoundInterest(double p, double r, int n, double y)` | Compound interest. |
| `double futureValue(double p, double r, double y)` | Future value. |
| `double presentValue(double f, double r, double y)` | Present value. |
| `double monthlyLoanPayment(double p, double r, int m)` | Monthly loan payment. |
| `double totalInterestPaid(double p, double pay, int m)` | Total interest paid. |
| `double profit(double rev, double cost)` | Profit. |
| `double profitMargin(double profit, double rev)` | Profit margin %. |
| `double markup(double cost, double price)` | Markup %. |
| `double discountPrice(double price, double off)` | Price after discount. |
| `double taxAmount(double amt, double rate)` | Tax amount. |
| `double breakEvenUnits(double fc, double price, double cost)` | Break-even units. |
| `double percentageChange(double old, double newV)` | % change. |
| `double savingsAfterYears(double monthly, double r, int y)` | Savings after years. |

### PhysicsUtils

| Method | Description |
|--------|-------------|
| `double speed(double d, double t)` | Speed = distance/time. |
| `double acceleration(double v0, double v1, double t)` | Acceleration. |
| `double force(double m, double a)` | Force = mass × acceleration. |
| `double kineticEnergy(double m, double v)` | Kinetic energy. |
| `double potentialEnergy(double m, double h)` | Gravitational potential energy. |
| `double work(double f, double d)` | Work done. |
| `double power(double w, double t)` | Power. |
| `double density(double m, double v)` | Density. |
| `double ohmsLawVoltage(double i, double r)` | Voltage = I × R. |
| `double momentum(double m, double v)` | Momentum. |
| `double gravitationalForce(double m1, double m2, double d)` | Gravitational force. |
| `double waveSpeed(double f, double wl)` | Wave speed. |
| `double pressure(double f, double a)` | Pressure. |
| `double springForce(double k, double x)` | Spring force. |

### TextAnalysisUtils

| Method | Description |
|--------|-------------|
| `int countChar(String s, char c)` | Count of a character. |
| `int countSentences(String s)` | Count sentence enders. |
| `String longestWord(String s)` | Longest word. |
| `String shortestWord(String s)` | Shortest word. |
| `boolean isAnagram(String a, String b)` | Anagram check. |
| `char mostFrequentChar(String s)` | Most frequent character. |
| `String replaceVowels(String s, char r)` | Replace vowels. |
| `boolean isIsogram(String s)` | Isogram check. |
| `int countDigits(String s)` | Count digits. |
| `int countSpecialChars(String s)` | Count special chars. |

### NumberTheoryUtils

| Method | Description |
|--------|-------------|
| `boolean isArmstrong(int n)` | Armstrong number check. |
| `boolean isPerfect(int n)` | Perfect number check. |
| `boolean isAbundant(int n)` | Abundant number check. |
| `boolean isDeficient(int n)` | Deficient number check. |
| `int sumOfDivisors(int n)` | Sum of proper divisors. |
| `boolean isCoprime(int a, int b)` | Coprime check. |
| `int eulerTotient(int n)` | Euler's totient. |
| `int digitSum(int n)` | Sum of digits. |
| `int reverseNumber(int n)` | Reversed number. |
| `boolean isHappy(int n)` | Happy number check. |
| `int numberOfDigits(int n)` | Digit count. |
| `boolean isPowerOfTwo(int n)` | Power-of-two check. |

### ProbabilityUtils

| Method | Description |
|--------|-------------|
| `double combination(int n, int r)` | n choose r. |
| `double permutation(int n, int r)` | n P r. |
| `double probabilityOfEvent(int fav, int total)` | Event probability. |
| `double expectedValue(double[] v, double[] p)` | Expected value. |
| `double binomialProbability(int n, int k, double p)` | Binomial probability. |
| `double diceRollProbability(int fav)` | Two-dice probability. |
| `double conditionalProbability(double pAB, double pB)` | Conditional probability. |
| `double complementProbability(double p)` | Complement probability. |

### MatrixUtils (int matrices)

| Method | Description |
|--------|-------------|
| `void printMatrix(int[][] m)` | Print a matrix. |
| `int[][] transpose(int[][] m)` | Transpose. |
| `int[][] addMatrices(int[][] a, int[][] b)` | Add matrices. |
| `int[][] multiplyMatrices(int[][] a, int[][] b)` | Multiply matrices. |
| `int[][] scalarMultiply(int[][] m, int s)` | Scalar multiply. |
| `int[][] identityMatrix(int n)` | Identity matrix. |
| `boolean isSquare(int[][] m)` | Square check. |
| `int sumAll(int[][] m)` | Sum of all elements. |
| `int trace(int[][] m)` | Trace. |
| `int[][] rotate90(int[][] m)` | Rotate 90°. |
| `int[] flatten(int[][] m)` | Flatten to 1D. |

### RandomUtils

| Method | Description |
|--------|-------------|
| `int randomInt(int min, int max)` | Random int in range. |
| `double randomDouble()` | Random double 0..1. |
| `double randomBetween(double min, double max)` | Random double in range. |
| `boolean randomBoolean()` | Random boolean. |
| `String randomChoice(String[] opts)` | Random element. |
| `int rollDie(int sides)` | Roll a die. |
| `char randomChar()` | Random lowercase letter. |
| `int[] shuffle(int[] arr)` | In-place shuffle. |

---

## Advanced Utilities

Algorithmic, cryptographic, combinatorial, calculus, statistics, data-structure,
and linear-algebra helpers (~81 functions).

### AlgorithmUtils

| Method | Description |
|--------|-------------|
| `void bubbleSort(int[] arr)` | Bubble sort (in place). |
| `void selectionSort(int[] arr)` | Selection sort (in place). |
| `void insertionSort(int[] arr)` | Insertion sort (in place). |
| `int[] mergeSort(int[] arr)` | Merge sort (returns new array). |
| `int binarySearch(int[] arr, int t)` | Binary search (sorted). |
| `int linearSearch(int[] arr, int t)` | Linear search. |
| `int fibonacciIterative(int n)` | Fibonacci (iterative). |
| `int fibonacciRecursive(int n)` | Fibonacci (recursive). |
| `boolean isSorted(int[] arr)` | Sorted check. |
| `void rotateArray(int[] arr, int k)` | Rotate array by k. |
| `int longestIncreasingSubsequence(int[] arr)` | LIS length. |
| `int[] twoSum(int[] arr, int t)` | Two-sum indices. |
| `int kadaneMaxSubarray(int[] arr)` | Max subarray sum. |

### CryptoUtils

| Method | Description |
|--------|-------------|
| `String caesarEncrypt(String t, int s)` | Caesar cipher encrypt. |
| `String caesarDecrypt(String t, int s)` | Caesar cipher decrypt. |
| `String rot13(String t)` | ROT13. |
| `String atbash(String t)` | Atbash cipher. |
| `String reverseCipher(String t)` | Reversed text. |
| `String xorCipher(String t, char k)` | XOR cipher. |
| `String vigenereEncrypt(String t, String k)` | Vigenère encrypt. |
| `String vigenereDecrypt(String t, String k)` | Vigenère decrypt. |
| `String simpleHash(String t)` | Simple string hash. |
| `String sha256Hex(String t)` | SHA-256 hex digest. |
| `String base64Encode(String t)` | Base64 encode. |
| `String base64Decode(String t)` | Base64 decode. |

### CombinatoricsUtils

| Method | Description |
|--------|-------------|
| `double permutation(int n, int r)` | n P r. |
| `double combination(int n, int r)` | n C r. |
| `int factorial(int n)` | Factorial. |
| `int catalan(int n)` | Catalan number. |
| `int binomialCoefficient(int n, int k)` | Binomial coefficient. |
| `int powerSetSize(int n)` | Size of power set. |
| `int derangements(int n)` | Derangement count. |
| `int triangularNumber(int n)` | Triangular number. |
| `int tetrahedralNumber(int n)` | Tetrahedral number. |
| `int lucasNumber(int n)` | Lucas number. |

### CalculusUtils

| Method | Description |
|--------|-------------|
| `double derivative(DoubleUnaryOperator f, double x)` | Numerical derivative. |
| `double secondDerivative(DoubleUnaryOperator f, double x)` | Second derivative. |
| `double trapezoidalIntegral(...)` | Trapezoidal integration. |
| `double simpsonIntegral(...)` | Simpson's integration. |
| `double riemannSumLeft(...)` | Left Riemann sum. |
| `double riemannSumRight(...)` | Right Riemann sum. |
| `double limitFromRight(DoubleUnaryOperator f, double x)` | Right-hand limit. |
| `double taylorTerm(double x, int n)` | Taylor series term. |
| `double eApproximation(int terms)` | Approximate e. |
| `double partialSum(DoubleUnaryOperator t, int n)` | Partial sum. |

### StatisticsAdvancedUtils

| Method | Description |
|--------|-------------|
| `double mean(double[] data)` | Mean. |
| `double covariance(double[] x, double[] y)` | Covariance. |
| `double correlation(double[] x, double[] y)` | Pearson correlation. |
| `double linearRegressionSlope(double[] x, double[] y)` | Regression slope. |
| `double linearRegressionIntercept(double[] x, double[] y)` | Regression intercept. |
| `double rSquared(double[] x, double[] y)` | R-squared. |
| `double zScore(double v, double mu, double sigma)` | Z-score. |
| `double standardError(double[] data)` | Standard error. |
| `double tStatistic(...)` | t-statistic. |
| `double normalCDF(double x)` | Normal CDF. |
| `double confidenceInterval(...)` | Margin of error. |

### DataStructuresUtils

| Method | Description |
|--------|-------------|
| `int[] removeDuplicates(int[] arr)` | Dedup array. |
| `int[] union(int[] a, int[] b)` | Set union. |
| `int[] intersection(int[] a, int[] b)` | Set intersection. |
| `int[] difference(int[] a, int[] b)` | Set difference. |
| `boolean isSubset(int[] sub, int[] set)` | Subset check. |
| `int secondLargest(int[] arr)` | Second largest. |
| `int kthLargest(int[] arr, int k)` | Kth largest. |
| `int[] rotateRight(int[] arr, int k)` | Rotate right. |
| `int mostFrequent(int[] arr)` | Most frequent value. |
| `int[] compress(int[] arr)` | Run-length compress. |

### LinearAlgebraUtils

| Method | Description |
|--------|-------------|
| `double dotProduct(double[] a, double[] b)` | Dot product. |
| `double vectorMagnitude(double[] v)` | Vector magnitude. |
| `double[] crossProduct(double[] a, double[] b)` | Cross product (3D). |
| `double[][] matrixAdd(double[][] a, double[][] b)` | Add matrices. |
| `double[][] matrixMultiply(double[][] a, double[][] b)` | Multiply matrices. |
| `double[][] matrixTranspose(double[][] m)` | Transpose. |
| `double determinant2x2(double[][] m)` | 2×2 determinant. |
| `double determinant3x3(double[][] m)` | 3×3 determinant. |
| `double trace(double[][] m)` | Trace. |
| `double[][] scalarMultiply(double[][] m, double s)` | Scalar multiply. |
| `double[][] identityMatrix(int n)` | Identity matrix. |
| `double[][] inverse2x2(double[][] m)` | 2×2 inverse. |

---

## License

Free to use for learning and school projects.
