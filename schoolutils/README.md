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

## License

Free to use for learning and school projects.
