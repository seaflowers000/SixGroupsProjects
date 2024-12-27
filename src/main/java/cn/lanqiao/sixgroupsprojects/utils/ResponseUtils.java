
package cn.lanqiao.sixgroupsprojects.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtils<T> {
    private Integer code;//状态码
    private String message;//信息
    private T data;//数据

    public ResponseUtils(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
