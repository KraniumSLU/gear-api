package com.kranium.project.gearapi.modules.session.metadataExtract.service;

import com.kranium.project.gearapi.modules.session.metadataExtract.dtos.ClientMetadataDTO;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Locale;

@Service
public class ClientMetadataExtractService {
    public ClientMetadataDTO extractService(HttpServletRequest request){
        String ip = extractClientIp(request);
        String userAgent = request.getHeader("User-Agent");
        String device = extractDevice(userAgent);
        return new ClientMetadataDTO(
                ip,
                userAgent,
                device
        );
    }

    private String extractClientIp(HttpServletRequest request){
        String forwardedd = request.getHeader("X-forwardedd-For");
        if (forwardedd!=null&&forwardedd.isBlank()){
            return forwardedd.split(",")[0];
        }
        return request.getRemoteAddr();
    }

    private String extractDevice(String userAgent){
        if (userAgent == null){
            return "NULL";
        }
        String ua= userAgent.toLowerCase();
        if (ua.contains("mobile")){
            return "MOBILE";
        }

        if (ua.contains("windows")){
            return "WINDOWS";
        }

        if (ua.contains("linux")){
            return "LINUX";
        }
        if (ua.contains("android")){
            return "ANDROID";
        }
        if (ua.contains("iphone")){
            return "IPHONE";
        }
        if (ua.contains("desktop")){
            return "DESKTOP";
        }
        if (ua.contains("tv")){
            return "TV";
        }
        if (ua.contains("iemobile")){
            return "IE_MOBILE";
        }
        return "UNKNOW";
    }
}
