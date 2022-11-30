package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 800,message = "Không được quá 800 ký tự")
    @Pattern(regexp = "^[A-Z0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]*([ ]+[A-Z][a-zđáàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)*([ ]+[0-9]*)*",
            message = "Tên không hợp lệ")
    private String name;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 300,message = "Không được quá 300 ký tự")
    @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$",
            message = "{Tên không hợp lệ}")
    private String artist;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 1000,message = "Không được quá 1000 ký tự")
    @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩị.đùúủũụưứửữựỷỹ0-9,]*([ ]+[A-Z][a-zđáàảãạăâẩắằấầặ,ẵẫậéèẻẽẹếềểễệóòêỏõọô.ốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)*",
            message = "{Thể loại không hợp lệ}")
    private String kindOfMusic;

    public SongDto(int id, @NotEmpty(message = "Không được để trống") @Size(max = 800, message = "Không được quá 800 ký tự") @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]*([ ]+[a-zđáàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)+",
            message = "Tên không hợp lệ") String name, @NotEmpty(message = "Không được để trống") @Size(max = 300, message = "Không được quá 300 ký tự") @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$",
            message = "Tên không hợp lệ") String artist, @NotEmpty(message = "Không được để trống") @Size(max = 1000, message = "Không được quá 1000 ký tự") @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩị.đùúủũụưứửữựỷỹ0-9,]*([ ]+[a-zđáàảãạăâẩắằấầặ,ẵẫậéèẻẽẹếềểễệóòêỏõọô.ốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)*",
            message = "Thể loại không hợp lệ") String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
