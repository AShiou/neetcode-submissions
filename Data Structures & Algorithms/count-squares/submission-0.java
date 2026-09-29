class CountSquares {

    private Map<Integer, Map<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> ys = map.get(x);
        ys.put(y, ys.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!map.containsKey(x)) {
            return 0;
        }

        int result = 0;

        for (int x2 : map.keySet()) {
            if (x2 == x) {
                continue;
            }

            Map<Integer, Integer> ys2 = map.get(x2);
            if (!ys2.containsKey(y)) {
                continue;
            }
            int side = Math.abs(x2 - x);

            int upY = y + side;
            if (map.get(x).containsKey(upY) && ys2.containsKey(upY)) {
                result += map.get(x).get(upY) * ys2.get(y) * ys2.get(upY);
            }

            int downY = y - side;
            if (map.get(x).containsKey(downY) && ys2.containsKey(downY)) {
                result += map.get(x).get(downY) * ys2.get(y) * ys2.get(downY);
            }
        }

        return result;
    }
}
