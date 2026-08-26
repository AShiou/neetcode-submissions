class TimeMap {

    private Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<String, List<TimeValue>>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<TimeValue> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;

        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            TimeValue midTimeValue = list.get(mid);
            if (midTimeValue.timestamp() == timestamp) {
                return midTimeValue.value();
            }
            if (midTimeValue.timestamp() < timestamp) {
                result = midTimeValue.value();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // static class TimeValue {
    //     private int timestamp;
    //     private String value;

    //     public TimeValue(int timestamp, String value) {
    //         this.timestamp = timestamp;
    //         this.value = value;
    //     }

    //     public int getTimestamp() {
    //         return timestamp;
    //     }

    //     public String getValue() {
    //         return value;
    //     }
    // }
    record TimeValue(int timestamp, String value) {}
}
