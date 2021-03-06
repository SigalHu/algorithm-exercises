## 4. 寻找两个有序数组的中位数

### 方法：递归法

为了解决这个问题，我们需要理解 “中位数的作用是什么”。在统计中，中位数被用来：

> 将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。

如果理解了中位数的划分作用，我们就很接近答案了。

首先，让我们在任一位置 $i$ 将 $\text{A}$ 划分成两个部分：

```java
          left_A             |        right_A
    A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
```

由于 $\text{A}$ 中有 $m$ 个元素，所以我们有 $m + 1$ 种划分的方法（$i = 0 \sim m$）。

我们知道：

```java
len(left_A)=i,len(right_A)=m−i.
```
注意：当 $i = 0$ 时，$\text{left\_A}$ 为空集，而当 $i = m$ 时，$\text{right\_A}$ 为空集。

采用同样的方式，我们在任一位置 $j$ 将 $\text{B}$ 划分成两个部分：

```java
          left_B             |        right_B
    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
```

将 $\text{left\_A}$ 和 $\text{left\_B}$ 放入一个集合，并将 $\text{right\_A}$ 和 $\text{right\_B}$ 放入另一个集合。再把这两个新的集合分别命名为 $\text{left\_part}$ 和 $\text{right\_part}$：

```java
          left_part          |        right_part
    A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
```

如果我们可以确认：

1. `len(left_part)=len(right_part)`
2. $\max(\text{left\_part}) \leq \min(\text{right\_part})$

那么，我们已经将 $\{\text{A}, \text{B}\}$ 中的所有元素划分为相同长度的两个部分，且其中一部分中的元素总是大于另一部分中的元素。那么：

$\text{median} = \frac{\text{max}(\text{left}\_\text{part}) + \text{min}(\text{right}\_\text{part})}{2}$

要确保这两个条件，我们只需要保证：

1. $i + j = m − i + n − j$（或：$m - i + n - j + 1$）如果 $n \geq m$，只需要使 $i = 0 \sim m, j = \frac{m + n + 1}{2} - i$
2. $\text{B}[j-1] \leq \text{A}[i]$ 以及 $\text{A}[i-1] \leq \text{B}[j]$

ps.1 为了简化分析，我假设 $\text{A}[i-1], \text{B}[j-1], \text{A}[i], \text{B}[j]$ 总是存在，哪怕出现 $i = 0$，$i = m$，$j = 0$，或是 $j = n$ 这样的临界条件。我将在最后讨论如何处理这些临界值。

ps.2 为什么 $n \geq m$？由于 $0 \leq i \leq m$ 且 $j = \frac{m + n + 1}{2} - i$，我必须确保 $j$ 不是负数。如果 $n < m$，那么 $j$ 将可能是负数，而这会造成错误的答案。

所以，我们需要做的是：

> 在 $[0，m]$ 中搜索并找到目标对象 $i$，以使：
> $\qquad \text{B}[j-1] \leq \text{A}[i]$ 且 $\text{A}[i-1] \leq \text{B}[j]$，其中 $j = \frac{m + n + 1}{2} - i$

接着，我们可以按照以下步骤来进行二叉树搜索：

1. 设 $\text{imin} = 0$，$\text{imax} = m$，然后开始在 $[\text{imin}, \text{imax}]$ 中进行搜索。
2. 令 $i = \frac{\text{imin} + \text{imax}}{2}$，$j = \frac{m + n + 1}{2} - i$
3. 现在我们有 $\text{len}(\text{left}\_\text{part})=\text{len}(\text{right}\_\text{part})$。而且我们只会遇到三种情况：
    * $\text{B}[j-1] \leq \text{A}[i]$ 且 $\text{A}[i-1] \leq \text{B}[j]$：
    这意味着我们找到了目标对象 $i$，所以可以停止搜索。
    * $\text{B}[j-1] > \text{A}[i]$：
    这意味着 $\text{A}[i]$ 太小，我们必须调整 $i$ 以使 $\text{B}[j-1] \leq \text{A}[i]$。

    > 我们可以增大 $i$ 吗？
    > 是的，因为当 $i$ 被增大的时候，$j$ 就会被减小。
    > 因此 $\text{B}[j-1]$ 会减小，而 $\text{A}[i]$ 会增大，那么 $\text{B}[j-1] \leq \text{A}[i]$ 就可能被满足。
    
    > 我们可以减小 $i$ 吗？
    > 不行，因为当 $i$ 被减小的时候，$j$ 就会被增大。
    > 因此 $\text{B}[j-1]$ 会增大，而 $\text{A}[i]$ 会减小，那么 $\text{B}[j-1] \leq \text{A}[i]$ 就可能不满足。

    > 所以我们必须增大 $i$。也就是说，我们必须将搜索范围调整为 $[i+1, \text{imax}]$。 因此，设 $\text{imin} = i + 1$，并转到步骤 2。

    * $\text{A}[i-1] > \text{B}[j]$：这意味着 $\text{A}[i-1]$ 太大，我们必须减小 $i$ 以使 $\text{A}[i-1]\leq \text{B}[j]$。也就是说，我们必须将搜索范围调整为 $[\text{imin}, i-1]$。
    因此，设 $\text{imax} = i - 1$，并转到步骤 2。

当找到目标对象 $i$ 时，中位数为：

* $\max(\text{A}[i-1], \text{B}[j-1])$，当 $m + n$ 为奇数时
* $\frac{\max(\text{A}[i-1], \text{B}[j-1]) + \min(\text{A}[i], \text{B}[j])}{2}$，当 $m + n$ 为偶数时

现在，让我们来考虑这些临界值 $i = 0, i = m, j = 0, j = n$，此时 $\text{A}[i-1], \text{B}[j-1], \text{A}[i], \text{B}[j]$ 可能不存在。其实这种情况比你想象的要容易得多。

我们需要做的是确保 $\text{max}(\text{left}\_\text{part}) \leq \text{min}(\text{right}\_\text{part})$。因此，如果 $i$ 和 $j$ 不是临界值（这意味着 $\text{A}[i-1], \text{B}[j-1],\text{A}[i],\text{B}[j]$ 全部存在），那么我们必须同时检查 $\text{B}[j-1] \leq \text{A}[i]$ 以及 $\text{A}[i-1] \leq \text{B}[j]$ 是否成立。但是如果 $\text{A}[i-1],\text{B}[j-1],\text{A}[i],\text{B}[j]$ 中部分不存在，那么我们只需要检查这两个条件中的一个（或不需要检查）。举个例子，如果 $i = 0$，那么 $\text{A}[i-1]$ 不存在，我们就不需要检查 $\text{A}[i-1] \leq \text{B}[j]$ 是否成立。所以，我们需要做的是：

> 在 $[0，m]$ 中搜索并找到目标对象 $i$，以使：
> ($j = 0$ or $i = m$ or $\text{B}[j-1] \leq \text{A}[i]$) 或是 ($i = 0$ or $j = n$ or $\text{A}[i-1] \leq \text{B}[j]$)，其中 $j = \frac{m + n + 1}{2} - i$

在循环搜索中，我们只会遇到三种情况：

1. ($j = 0$ or $i = m$ or $\text{B}[j-1] \leq \text{A}[i]$) 或是 ($i = 0$ or $j = n$ or $\text{A}[i-1] \leq \text{B}[j]$)，这意味着 $i$ 是完美的，我们可以停止搜索。
2. $j > 0$ and $i < m$ and $\text{B}[j - 1] > \text{A}[i]$ 这意味着 $i$ 太小，我们必须增大它。
3. $i > 0$ and $j < n$ and $\text{A}[i - 1] > \text{B}[j]$ 这意味着 $i$ 太大，我们必须减小它。

感谢 @Quentin.chen 指出：$i < m \implies j > 0$ 以及 $i > 0 \implies j < n$ 始终成立，这是因为：

$m \leq n,\ i < m \implies j = \frac{m+n+1}{2} - i > \frac{m+n+1}{2} - m \geq \frac{2m+1}{2} - m \geq 0$
$m \leq n,\ i > 0 \implies j = \frac{m+n+1}{2} - i < \frac{m+n+1}{2} \leq \frac{2n+1}{2} \leq n$

所以，在情况 2 和 3中，我们不需要检查 $j > 0$ 或是 $j < n$ 是否成立。

```java
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
```

**复杂度分析**

* 时间复杂度：$O\big(\log\big(\text{min}(m,n)\big)\big)$，首先，查找的区间是 $[0, m]$。而该区间的长度在每次循环之后都会减少为原来的一半。所以，我们只需要执行 $\log(m)$ 次循环。由于我们在每次循环中进行常量次数的操作，所以时间复杂度为 $O\big(\log(m)\big)$。由于 $m \leq n$，所以时间复杂度是 $O\big(\log\big(\text{min}(m,n)\big)\big)$。
* 空间复杂度：$O(1)$，我们只需要恒定的内存来存储 $9$ 个局部变量，所以空间复杂度为 $O(1)$。
