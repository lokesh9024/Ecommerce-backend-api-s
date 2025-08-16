package TheProductDto;

import lombok.Data;

@Data
public class ChangePasswordRequest {
	
  private long oldPassword;
  private long newPassword;
public long getOldPassword() {
	return oldPassword;
}
public void setOldPassword(long oldPassword) {
	this.oldPassword = oldPassword;
}
public long getNewPassword() {
	return newPassword;
}
public void setNewPassword(long newPassword) {
	this.newPassword = newPassword;
}
}
