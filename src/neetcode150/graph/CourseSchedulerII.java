package neetcode150.graph;

import java.util.*;

/**
 * Course Schedule II
 * You are given an array prerequisites where prerequisites[i] = [a, b]
 * indicates that you must take course b first if you want to take course a.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * There are a total of numCourses courses you are required to take,
 * labeled from 0 to numCourses - 1.
 * <p>
 * Return a valid ordering of courses you can take to finish all courses.
 * If there are many valid answers, return any of them. If it's not possible to
 * finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 3, prerequisites = [[1,0]]
 * <p>
 * Output: [0,1,2]
 * Explanation: We must ensure that course 0 is taken before course 1.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 3, prerequisites = [[0,1],[1,2],[2,0]]
 * <p>
 * Output: []
 * Explanation: It's impossible to finish all courses.
 * <p>
 * Constraints:
 * <p>
 * 1 <= numCourses <= 1000
 * 0 <= prerequisites.length <= 1000
 * All prerequisite pairs are unique.
 */
public class CourseSchedulerII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> visitedSet = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        Set<Integer> courseVisited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] preq : prerequisites) {
            map.get(preq[1]).add(preq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visitedSet, courseVisited, output)) {
                return new int[0];
            }
        }
        Collections.reverse(output);
        return output.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, HashSet<Integer> visitedSet,
                        Set<Integer> courseVisited, List<Integer> output) {
        if (visitedSet.contains(course)) return false;
        if (courseVisited.contains(course)) return true;
        visitedSet.add(course);

        for (int preq : map.get(course)) {
            if (!dfs(preq, map, visitedSet, courseVisited, output)) {
                return false;
            }
        }
        visitedSet.remove(course);
        courseVisited.add(course);
        output.add(course);
        return true;

    }
}
