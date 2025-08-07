const GO_KEY =
	"qKhW5l3qMZ7vggfkiEeB%2FroS7hi%2BV2mYQVSFqnuBbsow954NYhnhwmoFYa7VYRgN0avF6WpT2K7FqLAxtAyoyA%3D%3D"
const prevBtn = document.querySelector(".prev")
const nextBtn = document.querySelector(".next")
const searchBtn = document.querySelector(".searchBtn")
const searchInput = document.querySelector(".inp")
const linkbtn = document.querySelectorAll(".link-btn")

// const loading = document.getElementById("loading")
let currentPage = 1
let totalPage = 1
let searchKeyword = "서울"


//console.log(currentPage)

// 지역별 관광정보 출력 함수
async function getUser(page = 1) {
	try {
		const tourRes = await axios.get(
			`http://apis.data.go.kr/B551011/KorService1/searchKeyword1?numOfRows=12&pageNo=${page}&MobileOS=ETC&MobileApp=AppTest&ServiceKey=${GO_KEY}&listYN=Y&arrange=O&areaCode=&sigunguCode=&cat1=&cat2=&cat3=&keyword=${searchKeyword}&_type=json`
		)

		const tourDataList = tourRes.data.response.body.items.item
		const totalCount = tourRes.data.response.body.totalCount
		const numOfRows = 12
		totalPage = Math.ceil(totalCount / numOfRows)
		console.log(tourDataList)
		console.log("토탈" + totalCount)
		console.log(tourRes.data)

		let html = ""

		// html에 관광세부 정보를 추가하는 반복문
		for (const tourData of tourDataList) {
			html += `
	          
              <div class="col-6 col-md-3">
               <div class="card rounded-3  position-relative overflow-hidden mb-3" style="width: 270px;">
                 <div class="viewImg position-relative overflow-hidden ">
				 <img  src="${tourData.firstimage !== ""
					? tourData.firstimage
					: "/images/no_img.png"
				}" alt="" class="w-100 " style="width: 100%; border-radius: 20px;" /></div>
                  <div class="card-body">
                    <p class="tourtitle text-center fw-bold">${tourData.title}</p>
                    <div class="extraBtn position-absolute" data-bs-toggle="modal" data-bs-target="#exampleModal"
                      data-title="${tourData.title}"
                      data-lat="${tourData.mapy}"
                      data-lng="${tourData.mapx}"
                      data-id="${tourData.contentid}"
                    >자세히보기</div>
                 </div>
               </div>
              </div>
      `
		}
		document.querySelector(".tourList").innerHTML = html
		document.querySelector(".total").innerHTML = totalCount
		currentPage = page
		pagination()
	} catch (error) {
		console.error("데이터x" + error)
	} finally {
		//loading.style.display = "none"
	}
}
//검색 버튼 클릭 시 검색 실행
searchBtn.addEventListener("click", () => {
	searchKeyword = searchInput.value.trim()
	searchInput.value = ""
	getUser()
})
getUser()

function keyBtn(key) {
	searchKeyword = key
	getUser()
}









