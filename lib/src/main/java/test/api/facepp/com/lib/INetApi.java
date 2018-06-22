package test.api.facepp.com.lib;

/**
 * @author by licheng on 2018/6/19.
 */

public interface INetApi {
    /**
     * 人脸检测
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888373">detect Api文档</>
     */
    void detect();

    /**
     * 人脸对比
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4887586">compare Api文档</>
     */
    void compare();

    /**
     * 创建 faceSet
     *
     * @see <a href="https://api-cn.faceplusplus.com/facepp/v3/faceset/create">faceset/create Api文档</>
     */
    void facesetCreate();


    /**
     * 从 faceSet 中检索人脸
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888381">search Api文档</>
     */
    void search();

    /**
     * 向 faceset 添加人脸
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888389">faceset/addface Api文档</>
     */
    void facesetAddFace();

    /**
     * 从 faceSet 中删除人脸
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888399">faceset/removeface Api文档</>
     */
    void facesetRemoveFace();

    /**
     * 更新 faceSet 的信息
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888401">faceset/update Api文档</>
     */
    void facesetUpdate();

    /**
     * 获取 faceSet 的详细信息
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888395">faceset/getdetail Api文档</>
     */
    void facesetDetail();

    /**
     * 删除 faceSet
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888393">faceset/delete Api文档</>
     */
    void facesetDelete();

    /**
     * 获取 Api key 下的 faceSet 列表
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888397">faceset/getfacesets Api文档</>
     */
    void facesetList();

    /**
     * 分析 faceToken（最多5个），得到关键点、属性等信息
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888383">face/analyze Api文档</>
     */
    void faceAnalyze();

    /**
     * 获取 faceToken 信息，image_id，人脸框，所属 faceSet
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888385">face/getdetail Api文档</>
     */
    void faceDetail();

    /**
     * 给 faceToken 设置 user_id（方便对接客户业务系统）
     *
     * @see <a href="https://console.faceplusplus.com.cn/documents/4888387">face/setuserid Api文档</>
     */
    void setFaceUserId();

}
