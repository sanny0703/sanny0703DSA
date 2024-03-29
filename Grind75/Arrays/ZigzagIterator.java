package Arrays;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 *
 *  For example, given two 1d vectors:
 *      v1 = [1, 2]
 *      v2 = [3, 4, 5, 6]
 *  By calling next repeatedly until hasNext returns false,
 *  the order of elements returned by next should be:
 *     [1, 3, 2, 4, 5, 6].
 *
 *
 *  ##################
 *  Follow up:
 *     What if you are given k 1d vectors?
 *     How well can your code be extended to such cases?
 *
 *
 *  Clarification for the follow up question - Update (2015-09-18):
 *  The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 *  If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
 *
 *  For example, given the following input:
 *      [1,2,3]
 *      [4,5,6,7]
 *      [8,9]
 *  It should return
 *     [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator implements Iterator<Integer> {
    private Queue<Iterator<Integer>>iterators ;
    public ZigzagIterator(List<Integer>v1,List<Integer>v2){
        iterators = new ArrayDeque<>();
        if(!v1.isEmpty())
            iterators.offer(v1.iterator());
        if(!v2.isEmpty())
            iterators.offer(v2.iterator());
    }
    @Override
    public Integer next(){
       Iterator<Integer> iterator = iterators.poll();
       int ret =iterator.next();
       if(iterator.hasNext())
           iterators.offer(iterator);
       return  ret;
    }
    @Override
    public boolean hasNext(){
        return !iterators.isEmpty();
    }
}
