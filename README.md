# App-Utils 
App tiện ích cuộc sống, đồ án môn lập trình di động nên chương trình sẽ không đề cập đến vấn đề bảo mật, hay quản lý session hay sso. 


## Chức năng
> **Người dùng**
## 1. Đăng ký tài khoản
      UI Flow:
      Khi người dùng khởi động phần mềm, người dùng cần đăng nhập, nếu chưa có tài khoản, người dùng cần đăng ký tài khoản,
      để đăng ký tài khoản người dùng cần điền các thông tin: họ tên, số điện thoại, mật khẩu. Trong đó, mỗi tài khoản chỉ 
      sử dụng 1 số điện thoại, mật khẩu chứa các ký tự hoa, thường và đăc biệt, và trên 12 ký tự.
      
      API:
      ==> Method: [POST] 
      ==> URL:    domain/v1/api/User
      ==> Body: @TaiKhoanModel {HoTen: String, MatKhau: String, SoDienThoai: String}
      
      Response: 
              {
                Data= success ?  @TaiKhoanModel : MessageError,
                Message= "Create New Account",
                Success = success ? true : false
              }
              
 ## 2. Đăng nhập
      
      UI Flow:
      Khi đăng nhập, người dùng cần điền 2 thông tin là số điện thoại và mật khẩu. Nếu nhập sai hệ thống sẽ thông báo 
      “sai số điện thoại hoặc mật khẩu”. Nếu đăng nhập thành công sẽ chuyển đến trang chủ. 
      
      API:
      ==> Method: [POST] 
      ==> URL:    domain/v1/api/User/Login
      ==> Body: @TaiKhoan {MatKhau: String, SoDienThoai: String}
      
      Response: 
              {
                Data= success ?  @TaiKhoan : MessageError,
                Message= "Login",
                Success = success ? true : false
              }
             
## 3. Trang chủ
    UI Flow:
    Tại trang chủ sẽ hiển thị danh sách các chức năng mà chương trình hỗ trợ: Tìm kiếm thợ sửa điện, tìm kiếm thợ sửa nước,
    tìm kiếm cây xăng gần đây, tìm kiếm tiệm sửa xe gần đây, cấp cứu xe máy, cấp cứu ô tô, ...
    
## 4. Thông tin thợ sửa chữa
    
    UI Flow:
    Khi người dùng chọn chức năng tìm kiếm thợ sửa điện, người dùng sẽ xem được danh sách các thợ sửa chữa gần đây đang hoạt động. 
    
    API:
      ==> Method: [GET] 
      ==> URL:    domain/v1/api/User/GetRepairerArround
      ==> Param:  Latitude: String , Longitude: String, page: int

      Response: 
              {
                Data= success ?  @List<Repairer> : MessageError,
                Message= "Get List Repairer Arround",
                Success = success ? true : false
              }
          
    UI Flow:
    Khi người dùng chọn vào một thợ sửa chữa có thể xem được thông tin của thợ sửa chữa bao gồm: họ tên, địa chỉ, số điện thoại,
    giới tính, hình ảnh.
    API:
      ==> Method: [GET] 
      ==> URL:    domain/v1/api/User/RepairerInfomation
      ==> Param:  ID: Guid(C#) UUID(java)

      Response: 
              {
                Data= success ?  @Repairer : MessageError,
                Message= "Get Infomation of Repairer By ID",
                Success = success ? true : false
              }
              
 ## 5. Liên hệ
      Tại mục xem thông tin thợ sửa chữa người dùng có thể nhấn liên hệ trưc tiếp với thợ sửa chữa. 
      
 ## 6. Góp ý
      Trong quá trình sử dụng ứng dụng, người dùng có thể gửi góp ý về quá trình sử dụng chương trình cho nhà phát triển
      để cải thiện sản phẩm tốt hơn.
      
 ## 7. Tìm kiếm thợ sửa chữa gần đây
      
      UI FLow:
      Khi người dùng nhấn vào item sửa điện, sẽ hiển thị danh sách các thợ sửa chữa gần đây đang hoạt động
      
      API:
      ==> Method: [GET] 
      ==> URL:    domain/v1/api/User/GetRepairerArround
      ==> Param:  @diaChi: String

      Response: 
              {
                Data= success ?  @List<RepairerDistance> : null,
                Message= "Get Repairer Arround",
                Success =  true 
              }

## 8. Chỉnh sửa thông tin cá nhấn
      UI Flow:
      Thông tin cá nhân của user chỉ được sửa chữa các trường như: Ngày tháng năm sinh, giới tính, họ tên, email, địa chỉ
      
      API:
      ==> Method: [PATCH] 
      ==> URL:    domain/v1/api/User/EditInfo
      ==> Body:  @UserEditProfileModel{
                                          uid: Guid(c#) || UUID(Java),
                                          hoTen: String,
                                          diaChi: String,
                                          dob: DateTime (ISO),
                                          gioiTinh: bool,
                                          email: String
                                          }

      Response: 
              {
                Data= success ? @User : null,
                Message= sucess ? "Edit info user" : @ErrorMessage,
                Success =  success ? true: false 
              }
      
      
## Chức năng của thợ sửa chữa
> Thợ sửa chữa
## 1. Đăng nhập
      UI Flow:
      Khi thợ sửa chữa mở chương trình lên, cần đăng nhập tài khoản để sử dụng.
      
      API:
      ==> Method: [POST] 
      ==> URL:    domain/v1/api/Repairer/Login
      ==> Param:  @RepairerModel{SoDienThoai: String, MatKhau: String}

      Response: 
              {
                Data= success ?  @Repairer : MessageError,
                Message= "Login",
                Success = success ? true : false
              }
      
      Trong đó, tài khoản này thợ sửa chữa sẽ được cung cấp khi đi đăng ký trở thành thành viên. 
      Khi vào chương tình, thợ sửa chữa có thể thực hiện các chức năng sau: 
      
## 2. Bật trạng thái nhận sửa chữa: 
      UI Flow:
      Khi bật trạng thái này lên, người dùng có thể xem được thông tin của mình trong danh sách thợ sửa chữa gần đây.
      
      API:
      ==> Method: [PATCH] 
      ==> URL:    domain/v1/api/Repairer/Active
      ==> Param:  id: String

      Response: 
              {
                Data= success ?  @Repairer : MessageError,
                Message= "Active | Non",
                Success = success ? true : false
              }
              
## 3. Xem thông tin cá nhân
      
      UI Flow:
      Thông tin cá nhân này khi đi đăng ký tài khoản sẽ được admin cập nhật, 
      nếu phát hiện bạn cần đến chi nhánh cung cấp để sửa chữa. 
      
## 4. Check thông tin
      
      UI Flow:
      Thợ sửa chữa có thể thông qua số điện thoại của khách có thể xem được thông tin của khách hàng.
      Trong đó, thợ sửa chữa có thể xác định chính xác vị trí để di chuyển dễ dàng hơn.
      
      API:
      ==> Method: [GET] 
      ==> URL:    domain/v1/api/Repairer/InformationUser
      ==> Param:  SoDienThoai: String

      Response: 
              {
                Data= success ?  @User : MessageError,
                Message= "Information Of User",
                Success = success ? true : false
              }
              
      
      
      
      
      
      
      
      
      
      
