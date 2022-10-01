# Segment Tree

#### <code>Let us consider the following problem to understand Segment Trees.

We have an array arr[0 . . . n-1]. We should be able to

Find the sum of elements from index l to r where 0 <= l <= r <= n-1
Change the value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <=
n-1.</code>

### Sum of range using Nested Loop

<code>A simple solution is to run a loop from l to r and calculate the sum of elements in the given range. To update a
value, simply do arr[i] = x. The first operation takes O(n) time and the second operation takes O(1) time. </code>

### Sum of range using Prefix Sum

<code>Another solution is to create another array and store the sum from start to i ,at the ith index in this array. The
sum of a given range can now be calculated in O(1) time, but update operation takes O(n) time now. This works well if
the number of query operations is large and very few updates.</code>

### Sum of range using Segment Tree

<code>The most efficient way is to use a segment tree, we can use a Segment Tree to do both operations in O(log(N))
time.</code>
