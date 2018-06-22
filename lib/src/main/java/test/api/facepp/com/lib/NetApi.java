package test.api.facepp.com.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by licheng on 2018/6/13.
 */
public class NetApi implements INetApi {

    private static final String API_KEY = "自己的 Api_key";

    private static final String API_SECRET = "自己的 Api_secret";

    private static final Map<String, String> AUTH_INFO = new HashMap<>();

    static {
        AUTH_INFO.put("api_key", API_KEY);
        AUTH_INFO.put("api_secret", API_SECRET);
    }

    @Override
    public void detect() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("return_landmark", "1");
        params.put("return_attribute", "age,gender");

        Utils.post("/detect", params, "lib/image/test.jpeg");
    }


    @Override
    public void compare() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        // 当然也能用 image_file_1, image_url_1的参数互相组合。
        params.put("face_token1", "填写自己的faceToken");
        params.put("face_token2", "填写自己的faceToken");

        Utils.post("/compare", params);
    }


    @Override
    public void facesetCreate() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("display_name", "旷视face++科技有限公司");
        params.put("outer_id", "table_user"); // 这里可以关联自己的数据库表名
        params.put("tags", "face");// 不能是中文，不能有++等特殊符号
        params.put("face_tokens", "016fd88044fb0f4ffe980b05577bb90e,372968d15ed00b4dc4d48a4800292393");
        params.put("user_data", "这里可以写些信息");

        Utils.post("/faceset/create", params);
    }


    @Override
    public void search() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("face_token", "016fd88044fb0f4ffe980b05577bb90e");
        params.put("faceset_token", "5bc9ebcaca172b0dcd4768e6545cf9c9");

        params.put("return_result_count", "3"); // 返回置信度 最高的3个

        Utils.post("/search", params);
    }


    @Override
    public void facesetAddFace() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("face_tokens", "372968d15ed00b4dc4d48a4800292393");
        params.put("faceset_token", "5bc9ebcaca172b0dcd4768e6545cf9c9");

        Utils.post("/faceset/addface", params);
    }


    @Override
    public void facesetRemoveFace() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("face_tokens", "372968d15ed00b4dc4d48a4800292393");
        params.put("faceset_token", "5bc9ebcaca172b0dcd4768e6545cf9c9");

        Utils.post("/faceset/removeface", params);
    }

    @Override
    public void facesetUpdate() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("faceset_token", "5bc9ebcaca172b0dcd4768e6545cf9c9");
        params.put("new_outer_id", "new_outer_id");

        Utils.post("/faceset/update", params);
    }

    @Override
    public void facesetDetail() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("faceset_token", "5bc9ebcaca172b0dcd4768e6545cf9c9");
        params.put("start", "1"); // 必须大于 0： 从第几个faceToken开始返回，一次返回100个

        Utils.post("/faceset/getdetail", params);
    }

    @Override
    public void facesetDelete() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("faceset_token", "2a26550e4932212056f50c733856ea91");
        params.put("check_empty", "0"); // 判空，如果空，才能删除

        Utils.post("/faceset/delete", params);
    }

    @Override
    public void facesetList() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("faceset_token", "5bc9ebcaca172b0dcd4768e6545cf9c9");
        params.put("start", "1"); // 从第几个faceSetToken开始返回，一次返回100个

        Utils.post("/faceset/getfacesets", params);
    }

    @Override
    public void faceAnalyze() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("face_tokens", "372968d15ed00b4dc4d48a4800292393");
        params.put("return_attributes", "age,gender");

        Utils.post("/face/analyze", params);
    }

    @Override
    public void faceDetail() {
        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("face_token", "372968d15ed00b4dc4d48a4800292393");

        Utils.post("/face/getdetail", params);
    }

    @Override
    public void setFaceUserId() {

        Map<String, String> params = new HashMap<>(AUTH_INFO);

        params.put("face_token", "372968d15ed00b4dc4d48a4800292393");
        params.put("user_id", "user_id_001");

        Utils.post("/face/setuserid", params);
    }
}
