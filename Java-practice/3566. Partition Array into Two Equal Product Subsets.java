class Solution {

    boolean findSubset(int index,double count1,double count2, double target, double values[]) {
        if(index == values.length) {
            return (Math.abs(count1 - target) < 1e-9 && Math.abs(count2 - target) < 1e-9);
        }

        if(Math.abs(count1 - target) < 1e-9 && Math.abs(count2 - target) < 1e-9) {
            return true;
        }

        boolean take = findSubset(index + 1,count1 + values[index], count2 - values[index],target, values);
        boolean notTake = findSubset(index + 1,count1, count2,target, values);
        return take || notTake;
    }


    public boolean checkEqualPartitions(int[] nums, long target) {
        double values[] = new double[nums.length];
        double total = 0;

        for(int i = 0;i < nums.length;i++) {
            values[i] = Math.log(nums[i]);
            total += values[i];
        }
        double newTarget = Math.log(target);

        return findSubset(0, 0, total, newTarget,values);

    }
}
