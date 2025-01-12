package pl.koder95.srs;

import lombok.Getter;

@Getter
public enum StandardMessage implements Message {

    // 1XX – Informational
    STATUS_100 ( 100, "Continue" ),
    STATUS_101 ( 101, "Switching Protocols" ),
    STATUS_102 ( 102, "Processing" ),
    STATUS_103 ( 103, "Early Hints" ),
    STATUS_110 ( 110, "Response Is Stale" ),
    STATUS_111 ( 111, "Revalidation Failed" ),
    STATUS_112 ( 112, "Disconnected Operation" ),
    STATUS_113 ( 113, "Heuristic Expiration" ),
    STATUS_199 ( 199, "Miscellaneous Warning" ),
    // 2XX – Success
    STATUS_200 ( 200, "OK" ),
    STATUS_201 ( 201, "Created" ),
    STATUS_202 ( 202, "Accepted" ),
    STATUS_203 ( 203, "Non-Authoritative Information" ),
    STATUS_204 ( 204, "No Content" ),
    STATUS_205 ( 205, "Reset Content" ),
    STATUS_206 ( 206, "Partial Content" ),
    STATUS_207 ( 207, "Multi-Status" ),
    STATUS_208 ( 208, "Already Reported" ),
    STATUS_214 ( 214, "Transformation Applied" ),
    STATUS_218 ( 218, "This Is Fine" ),
    STATUS_226 ( 226, "IM Used" ),
    STATUS_299 ( 226, "Miscellaneous Persistent Warning" ),
    // 3XX – Redirection
    STATUS_300 ( 300, "Multiple Choices" ),
    STATUS_301 ( 301, "Moved Permanently" ),
    STATUS_302 ( 302, "Found" ),
    STATUS_303 ( 303, "See Other" ),
    STATUS_304 ( 304, "Not Modified" ),
    STATUS_305 ( 305, "Use Proxy" ),
    STATUS_306 ( 306, "Switch Proxy" ),
    STATUS_307 ( 307, "Temporary Redirect" ),
    STATUS_308 ( 308, "Permanent Redirect" ),
    // 4XX – Client error
    STATUS_400 ( 400, "Bad Request" ),
    STATUS_401 ( 401, "Unauthorized" ),
    STATUS_402 ( 402, "Payment Required" ),
    STATUS_403 ( 403, "Forbidden" ),
    STATUS_404 ( 404, "Not Found" ),
    STATUS_405 ( 405, "Method Not Allowed" ),
    STATUS_406 ( 406, "Not Acceptable" ),
    STATUS_407 ( 407, "Proxy Authentication Required" ),
    STATUS_408 ( 408, "Request Timeout" ),
    STATUS_409 ( 409, "Conflict" ),
    STATUS_410 ( 410, "Gone" ),
    STATUS_411 ( 411, "Length Required" ),
    STATUS_412 ( 412, "Precondition Failed" ),
    STATUS_413 ( 413, "Payload Too Large" ),
    STATUS_414 ( 414, "URI Too Long" ),
    STATUS_415 ( 415, "Unsupported Media Type" ),
    STATUS_416 ( 416, "Range Not Satisfiable" ),
    STATUS_417 ( 417, "Expectation Failed" ),
    STATUS_418 ( 418, "I'm a Teapot" ),
    STATUS_419 ( 419, "Page Expired" ),
    STATUS_420 ( 420, "Method Failure or Enhance Your Calm" ),
    STATUS_421 ( 421, "Misdirected Request" ),
    STATUS_422 ( 422, "Unprocessable Entity" ),
    STATUS_423 ( 423, "Locked" ),
    STATUS_424 ( 424, "Failed Dependency" ),
    STATUS_425 ( 425, "Too Early" ),
    STATUS_426 ( 426, "Upgrade Required" ),
    STATUS_428 ( 428, "Precondition Required" ),
    STATUS_429 ( 429, "Too Many Requests" ),
    STATUS_430 ( 430, "HTTP Status Code" ),
    STATUS_431 ( 431, "Request Header Fields Too Large" ),
    STATUS_340 ( 440, "Login Time-Out" ),
    STATUS_444 ( 444, "No Response" ),
    STATUS_449 ( 449, "Retry With" ),
    STATUS_450 ( 450, "Blocked by Windows Parental Controls" ),
    STATUS_451 ( 451, "Unavailable For Legal Reasons" ),
    STATUS_460 ( 460, "Client Closed Connection Prematurely" ),
    STATUS_463 ( 463, "Too Many Forwarded IP Addresses" ),
    STATUS_464 ( 464, "Incompatible Protocol" ),
    STATUS_494 ( 494, "Request Header Too Large" ),
    STATUS_495 ( 495, "SSL Certificate Error" ),
    STATUS_496 ( 496, "SSL Certificate Required" ),
    STATUS_497 ( 497, "HTTP Request Sent to HTTPS Port" ),
    STATUS_498 ( 498, "Invalid Token" ),
    STATUS_499 ( 499, "Token Required or Client Closed Request" ),
    // 5XX – Server error
    STATUS_500 ( 500, "Internal Server Error" ),
    STATUS_501 ( 501, "Not Implemented" ),
    STATUS_502 ( 502, "Bad Gateway" ),
    STATUS_503 ( 503, "Service Unavailable" ),
    STATUS_504 ( 504, "Gateway Timeout" ),
    STATUS_505 ( 505, "HTTP Version Not Supported" ),
    STATUS_506 ( 506, "Variant Also Negotiates" ),
    STATUS_507 ( 507, "Insufficient Storage" ),
    STATUS_508 ( 508, "Loop Detected" ),
    STATUS_509 ( 509, "Bandwidth Limit Exceeded" ),
    STATUS_510 ( 510, "Not Extended" ),
    STATUS_511 ( 511, "Network Authentication Required" ),
    STATUS_520 ( 520, "Web Server Is Returning an Unknown Error" ),
    STATUS_521 ( 521, "Web Server Is Down" ),
    STATUS_522 ( 522, "Connection Timed Out" ),
    STATUS_523 ( 523, "Origin Is Unreachable" ),
    STATUS_524 ( 524, "A Timeout Occurred" ),
    STATUS_525 ( 525, "SSL Handshake Failed" ),
    STATUS_526 ( 526, "Invalid SSL Certificate" ),
    STATUS_527 ( 527, "Railgun Listener to Origin" ),
    STATUS_529 ( 529, "The Service Is Overloaded" ),
    STATUS_530 ( 530, "Site Frozen" ),
    STATUS_561 ( 561, "Unauthorized" ),
    STATUS_598 ( 598, "Network Read Timeout Error" ),
    STATUS_599 ( 599, "Network Connect Timeout Error" ),
    // 6XX – Custom error
    STATUS_600 ( 600, "JVM Exception" ),
    // 9XX – Unknown error
    STATUS_999 ( 999, "Unauthorized" );

    private final int statusCode;
    private final int group;
    private final String text;

    StandardMessage(int statusCode, String text) {
        this.statusCode = Math.abs(statusCode);
        this.group = this.statusCode / 100;
        this.text = text;
    }

    public boolean isInformational() {
        return getGroup() == 1;
    }

    public boolean isSuccess() {
        return getGroup() == 2;
    }

    public boolean isRedirection() {
        return getGroup() == 3;
    }

    public boolean isClientError() {
        return getGroup() == 4;
    }

    public boolean isServerError() {
        return getGroup() == 5;
    }

    public boolean isCustomError() {
        return getGroup() == 6;
    }

    public boolean isUnknownError() {
        return getGroup() == 9;
    }

    public boolean isError() {
        return isClientError() || isServerError() || isCustomError() || isUnknownError();
    }

    public static StandardMessage valueOf(int statusCode) {
        return statusCode < 100 || statusCode >= 1000? null : StandardMessage.valueOf("STATUS_" + statusCode);
    }
}
