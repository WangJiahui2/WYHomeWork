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

public class ConvertVoToDateBase {


    public WeiBoCache convert(WeiBoList wbList) {
        if (wbList == null) {
            return null;
        }
        WeiBoCache weiBoCache = new WeiBoCache();
        List<WeiBoCache.Content> contents = new ArrayList<>();

        List<StatusesDTO> statuses = wbList.getStatuses();
        for (int i = 0; i < statuses.size(); i++) {
            WeiBoCache.Content content = new WeiBoCache.Content();
            StatusesDTO statusesDTO = statuses.get(i);
            content.createdAt = statusesDTO.getCreatedAt();
            content.id = statusesDTO.getId();
            content.text = statusesDTO.getText();
            content.source = statusesDTO.getSource();
            content.picUrls = convertToPicUrls(statusesDTO.getPicUrls());
            content.retweetedStatus = convertToRetweeted(statusesDTO.getRetweetedStatus());
            content.user = convertToUser(statusesDTO.getUser());
            contents.add(content);
        }
        weiBoCache.contents = contents;
        return weiBoCache;
    }

    private WeiBoCache.Content.User convertToUser(UserDTO user) {
        WeiBoCache.Content.User userr = new WeiBoCache.Content.User();
        if (user != null){
            userr.name = user.getName();
            userr.profileImageUrl = user.getProfileImageUrl();
            userr.description = user.getDescription();
            userr.id = user.getId();
        }
        return userr;
    }

    private WeiBoCache.Content.Retweeted convertToRetweeted(RetweetedStatusDTO retweetedStatus) {
        if (retweetedStatus != null) {
            WeiBoCache.Content.Retweeted retweeted = new WeiBoCache.Content.Retweeted();
            retweeted.createdAt = retweetedStatus.getCreatedAt();
            retweeted.id = retweetedStatus.getId();
            retweeted.source = retweetedStatus.getSource();
            retweeted.text = retweetedStatus.getText();
            retweeted.picUrls = convertToPicUrlss(retweetedStatus.getPicUrls());
            retweeted.user = convertToUserX(retweetedStatus.getUser());
            return retweeted;
        } else {
            return null;
        }
    }

    private WeiBoCache.Content.User convertToUserX(UserDTOX user) {
        WeiBoCache.Content.User userr = new WeiBoCache.Content.User();
        userr.id = user.getId();
        userr.description = user.getDescription();
        userr.name = user.getName();
        userr.profileImageUrl = user.getProfileImageUrl();
        return userr;
    }

    /**
     * 从RetweetedStatusDTO的picUrls转换到WeiBoCache.Content.Retweeted的urls
     *
     * @param picUrls
     * @return
     */
    private List<WeiBoCache.Content.PicUrls> convertToPicUrlss(List<PicUrlsDTO> picUrls) {
        List<WeiBoCache.Content.PicUrls> picUrl = new ArrayList<>();
        WeiBoCache.Content.PicUrls urls = new WeiBoCache.Content.PicUrls();
        if (picUrls != null && !picUrls.isEmpty()){
            for (int i = 0; i < picUrls.size(); i++) {
                urls.thumbnailPic = picUrls.get(i).getThumbnailPic();
                picUrl.add(urls);
            }
        }
        return picUrl;
    }

    /**
     * 从StatusesDTO的picUrls转换到WeiBoCache.Content.Retweeted的urls
     *
     * @param picUrls
     * @return
     */
    private List<WeiBoCache.Content.PicUrls> convertToPicUrls(List<PicUrlsDTOX> picUrls) {
        if (picUrls != null && picUrls.size() > 0) {
            List<WeiBoCache.Content.PicUrls> list = new ArrayList<>(picUrls.size());
            WeiBoCache.Content.PicUrls urls = new WeiBoCache.Content.PicUrls();
            for (int i = 0; i < picUrls.size(); i++) {
                urls.thumbnailPic = picUrls.get(i).getThumbnailPic();
                list.add(i,urls);
            }
            return list;
        }else{
            return null;
        }
    }

}
