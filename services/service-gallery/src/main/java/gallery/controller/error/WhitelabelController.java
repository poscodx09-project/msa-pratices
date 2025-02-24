package gallery.controller.error;

import java.util.Optional;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gallery.dto.JsonResult;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class WhitelabelController implements ErrorController {
    @GetMapping
    public ResponseEntity<JsonResult<String>> handleError(HttpServletRequest request) {
        return ResponseEntity.status(Optional
                .ofNullable(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE))
                .map(statusCode -> Integer.valueOf(statusCode.toString()))
                .orElse(520))
                .body(JsonResult.fail("no message"));
    }
}
