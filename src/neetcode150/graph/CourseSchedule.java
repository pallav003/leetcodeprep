package neetcode150.graph;

import java.util.*;

/**
 * Course Schedule
 * You are given an array prerequisites where prerequisites[i] = [a, b]
 * indicates that you must take course b first if you want to take course a.
 * <p>
 * The pair [0, 1], indicates that must take course 1 before taking course 0.
 * <p>
 * There are a total of numCourses courses you are required to take, labeled from
 * 0 to numCourses - 1.
 * <p>
 * Return true if it is possible to finish all courses, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[0,1]]
 * <p>
 * Output: true
 * Explanation: First take course 1 (no prerequisites) and then take course 0.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[0,1],[1,0]]
 * <p>
 * Output: false
 * Explanation: In order to take course 1 you must take course 0,
 * and to take course 0 you must take course 1. So it is impossible.
 * <p>
 * Constraints:
 * <p>
 * 1 <= numCourses <= 1000
 * 0 <= prerequisites.length <= 1000
 * All prerequisite pairs are unique.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> visitedSet = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] preq : prerequisites) {
            map.get(preq[1]).add(preq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visitedSet)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, HashSet<Integer> visitedSet) {
        if (visitedSet.contains(course)) return false;
        if (map.get(course).isEmpty()) return true;
        visitedSet.add(course);

        for (int preq : map.get(course)) {
            if (!dfs(preq, map, visitedSet)) {
                return false;
            }
        }
        visitedSet.remove(course);
        map.put(course, new ArrayList<>());
        return true;

    }

}
