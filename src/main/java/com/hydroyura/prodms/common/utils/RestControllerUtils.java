package com.hydroyura.prodms.common.utils;

import static com.hydroyura.prodms.common.Constants.REQUEST_ATTR_UUID_KEY;
import static com.hydroyura.prodms.common.Constants.REQUEST_ATTR_TIMESTAMP_KEY;

import com.hydroyura.prodms.common.model.api.ApiRes;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class RestControllerUtils {

    public static <T> ApiRes<T> buildEmptyApiResponse(HttpServletRequest req) {
        ApiRes<T> apiResponse = new ApiRes<>();
        apiResponse.setId(extractRequestUUID(req));
        apiResponse.setTimestamp(extractRequestTimestamp(req));
        return apiResponse;
    }

    private static UUID extractRequestUUID(HttpServletRequest request) {
        return Optional
            .ofNullable(request.getAttribute(REQUEST_ATTR_UUID_KEY))
            .map(UUID.class::cast)
            .orElseThrow(RuntimeException::new);
    }

    private static Timestamp extractRequestTimestamp(HttpServletRequest request) {
        return Optional
            .ofNullable(request.getAttribute(REQUEST_ATTR_TIMESTAMP_KEY))
            .map(Timestamp.class::cast)
            .orElseThrow(RuntimeException::new);
    }

}
