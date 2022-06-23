package base.program;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

/**
 * 问题原型
 * @param <T>
 */
@Slf4j
@Data
public abstract class Topic<T> {
    // 输入泛型
    private T input;
    /**
     * 解决方案
     */
    public abstract Object program(T input);
    /**
     * 运行
     */
    public <E> Long run(E exceptOutPut){
        // 获取开始时间
        long startTime = System.nanoTime();
        // 断言判断输出是否正确
        Assertions.assertEquals(exceptOutPut,program(input),"输出结果不正确");
        // 获取结束时间
        long overTime = System.nanoTime();
        log.info("程序运行时间为："+(overTime-startTime)+"纳秒");
        // 返回总耗时（纳秒）
        return overTime-startTime;
    }

}
