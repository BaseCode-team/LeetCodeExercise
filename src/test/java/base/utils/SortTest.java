package base.utils;

import java.util.Arrays;

import org.junit.jupiter.api.*;

import base.utils.random.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class SortTest {
    int[] nums = Random.randomCommon(0, 20, 10);

    @BeforeEach
    void before() {
        log.info("BeforeSort: " + Arrays.toString(nums));
    }

    @AfterEach
    void after(TestInfo testInfo) {
        log.info(testInfo.getDisplayName() + ": " + Arrays.toString(nums));
    }

    @Test
    @DisplayName("SelectSort")
    void selectSort() {
        Sort.selectSort(nums);
    }

    @Test
    @DisplayName("SelectSort")
    void bubbleSort() {
        Sort.bubbleSort(nums);
    }

    @Test
    @DisplayName("InsertSort")
    void insertSort() {
        Sort.insertSort(nums);
    }

    @Test
    @DisplayName("QuickSort")
    void quickSort() {
        Sort.quickSort(nums, 0, nums.length - 1);
    }

    @Test
    @DisplayName("MergeSort")
    void mergeSort() {
        Sort.mergeSort(nums, 0, nums.length - 1);
    }

    @Test
    @DisplayName("HillSort")
    void hillSort() {
        Sort.hillSort(nums);
    }

    @Test
    @DisplayName("BucketSort")
    void bucketSort() {
        Sort.bucketSort(nums);
    }
}