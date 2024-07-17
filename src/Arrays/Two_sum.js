const bruteForce = function (nums, target) {
  for (let i = 0; i < nums.length; i++) {
    for (let j = 0; j < nums.length; j++) {
      if (i !== j) {
        if (nums[i] + nums[j] === target) {
          console.log(nums[i], nums[j]);
          return [i, j];
        }
      }
    }
  }
  return null;
};

const better = function (arr, target) {
  let hsh = {};
  for (let i = 0; i < arr.length; i++) {
    let num = arr[i];
    let moreNeeded = target - num;
    if (hsh[moreNeeded] != undefined) {
      return [hsh[moreNeeded], i];
    }
    hsh[num] = i;
  }
  return [-1, -1];
};

// const optimal = function (arr, target) {
//   // sort nums
//   let nums = [...arr].sort((a, b) => a - b);
//   //apply two pointers
//   let left = 0,
//     right = nums.length - 1;
//   while (left < right) {
//     if (left != right && nums[left] + nums[right] == target) {
//       return [arr.indexOf(nums[left]), arr.indexOf(nums[right])];
//     } else if (nums[left] + nums[right] < target) {
//       left++;
//     } else {
//       right--;
//     }
//   }
// };

let nums = [3, 3];
let target = 6;

let ans = optimal(nums, target);
console.log(ans);
