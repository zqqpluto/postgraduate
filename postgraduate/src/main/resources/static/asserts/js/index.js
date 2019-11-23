$(document).on('click', '.browse', function(){
  var file = $(this).parent().parent().parent().find('.file');
  file.trigger('click');
});
$(document).on('change', '.file', function(){
  $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
  var fileName = $(this).parent().find('.form-control').val();
  // var lastName = fileName.split("\.")[1];
  // if ( lastName== "xls" || lastName == "xlsx"){
  //
  //   console.log("123456")
  //   var fi = this.files[0];
  //   console.log(fi);
  //
  //   var reader = new FileReader();
  //
  //   reader.onload = function(e){
  //     console.log("onLoad")
  //     var data = e.target.result;
  //     var wb = XLSX.read(data, {
  //       type: 'binary'
  //      });
  //
  //     //wb.SheetNames[0]是获取Sheets中第一个Sheet的名字
  //     //wb.Sheets[Sheet名]获取第一个Sheet的数据
  //     console.log(JSON.stringify(XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]])));
  //     // document.getElementById("demo").innerHTML= JSON.stringify( XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]) );
  //
  //   };
  //   reader.readAsBinaryString(fi);
  //
  // }
});