package com.wangyi.wyhomework.utils;

import com.wangyi.wyhomework.cache.WeiBoCache;
import com.wangyi.wyhomework.model.weibolist.PicUrlsDTO;
import com.wangyi.wyhomework.model.weibolist.PicUrlsDTOX;
import com.wangyi.wyhomework.model.weibolist.RetweetedStatusDTO;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.model.weibolist.UserDTO;
import com.wangyi.wyhomework.model.weibolist.UserDTOX;
import com.wangyi.wyhomework.model.weibolist.WeiBoList;

import java.util.ArrayList;
import java.util.List;

public class ConvertDateBaseToVo {
    
    
    public  WeiBoList convert(WeiBoCache weiBoCache){
        if (weiBoCache == null){
            return null;
        }
        List<WeiBoCache.Content> contents = weiBoCache.contents;
        WeiBoList weiBoList = new WeiBoList();
        List<StatusesDTO> statusesDTOS = new ArrayList<>();
        for (int i = 0; i < contents.size(); i++) {
            StatusesDTO statusesDTO = new StatusesDTO();
            WeiBoCache.Content content = contents.get(i);
            statusesDTO.setCreatedAt(content.createdAt);
            statusesDTO.setId(content.id);
            statusesDTO.setText(content.text);
            statusesDTO.setSource(content.source);
            statusesDTO.setPicUrls(convertToPicUrlsDTOX(content.picUrls));
            statusesDTO.setUser(convertToUserDTO(content.user));
            statusesDTO.setRetweetedStatus(convertToRetweetedStatusDTO(content.retweetedStatus));
            statusesDTOS.add(statusesDTO);
        }
        weiBoList.setStatuses(statusesDTOS);
        return weiBoList;
    }


    private RetweetedStatusDTO convertToRetweetedStatusDTO(WeiBoCache.Content.Retweeted retweetedStatus) {
        if (retweetedStatus != null){
            RetweetedStatusDTO retweetedStatusDTO = new RetweetedStatusDTO();
            retweetedStatusDTO.setCreatedAt(retweetedStatus.createdAt);
            retweetedStatusDTO.setId(retweetedStatus.id);
            retweetedStatusDTO.setText(retweetedStatus.text);
            retweetedStatusDTO.setSource(retweetedStatus.source);
            retweetedStatusDTO.setUser(convertToUserDTOX(retweetedStatus.user));
            retweetedStatusDTO.setPicUrls(convertToPicUrlsDTO(retweetedStatus.picUrls));
            return retweetedStatusDTO;
        }else{
            return null;
        }
        
    }

    private List<PicUrlsDTO> convertToPicUrlsDTO(List<WeiBoCache.Content.PicUrls> picUrls) {
        if (picUrls != null && picUrls.size() > 0){
            List<PicUrlsDTO> picUrlsDTOList = new ArrayList<>(picUrls.size());
            for (int i = 0; i < picUrls.size(); i++) {
                picUrlsDTOList.get(i).setThumbnailPic(picUrls.get(i).thumbnailPic);
            }
            return picUrlsDTOList;
        }else{
            return null;
        }
    }

    private UserDTOX convertToUserDTOX(WeiBoCache.Content.User user) {
        UserDTOX userDTO = new UserDTOX();
        userDTO.setId(user.id);
        userDTO.setName(user.name);
        userDTO.setDescription(user.description);
        userDTO.setProfileImageUrl(user.profileImageUrl);
        return userDTO;

    }

    private UserDTO convertToUserDTO(WeiBoCache.Content.User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.id);
        userDTO.setName(user.name);
        userDTO.setDescription(user.description);
        userDTO.setProfileImageUrl(user.profileImageUrl);
        return userDTO;
    }

    private List<PicUrlsDTOX> convertToPicUrlsDTOX(List<WeiBoCache.Content.PicUrls> picUrls) {
        List<PicUrlsDTOX> picUrlsDTOXList = new ArrayList<>(picUrls.size());
        for (int i = 0; i < picUrls.size(); i++) {
            picUrlsDTOXList.get(i).setThumbnailPic(picUrls.get(i).thumbnailPic);
        }
        return picUrlsDTOXList;
    }
}
