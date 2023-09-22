package com.piece;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.piece.repository.PicDao;
import com.piece.repository.PostDao;
import com.piece.service.ifs.PostService;

@SpringBootTest(classes = PieceApplication.class)
public class PieceApplicationTests {
	@Autowired
	private PostService postService;
	@Autowired
	private PicDao picDao;
	@Autowired
	private PostDao postDao;

	@Test
	public void contextLoads() {
//		data:image/png;base64,
//		String base64Image = "/9j/4AAQSkZJRgABAQEAeAB4AAD/2wBDAAYEBQYFBAYGBQYHBwYIChAKCgkJChQODwwQFxQYGBcUFhYaHSUfGhsjHBYWICwgIyYnKSopGR8tMC0oMCUoKSj/2wBDAQcHBwoIChMKChMoGhYaKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCj/wAARCAH4AfQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDt6KKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACtfQdCuNXc+UQkS9XIrKjQySKi9WOBXsGg2S6fpVvCAAwUFvqetAHNR+A49vz3rZ9k/+vTv+EEg/wCfx/8Avj/69dnRQBxZ8Bw44vH/AO+P/r1QvvA9zEpa1uEl9iu0/wBa9DooA8VvbG4spClzEyN7iq9e13lpBeQmO5jWRD2YZrhfEXhB7dTPp3zp3j7j6UAcdRSurIxVwQw4INJQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFKiM7YRSx9AM0AJRVl7C6SPe1vKF9StVqACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKANnwjAlxr1ukoyoy2K9ZryvwP8A8jFB9DXqlABRRRQAUUUUAFFFFAHK+LfDaXsTXVmgW5HLAcb/AP69ecyI0bsjgqynBB7V7hXnvjzRvIuPt8Cny5Mbx6HpQBx9FFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRT4IZJ5BHCjO56BRk0AMorsdJ8FTTbXv5DEpGdijmuqsPD2nWSjy4A7D+Jzk0AeTxwySNiON3Poq5rTsvDup3f3LV1Hq/y/wA69XjtoI/uRRr9FqXpQBw2meB+jahN/wABQ10+n6Jp9go8i2TcP4mGT+taVFADXjR0Kuqsp4II4ryvxfpq6bqrLEu2KT5lHpXq1cR8SbdjHaTj7qkqfxx/hQBwlFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAb3gf/kYoPoa9UryvwP8A8jFB9DXqlABRRRQAUUUUAFFFFABUV3bx3VtJDMMo6lTUtFAHj+v6XJpN+0L8ofmRvUVm1614m0ePVrIjAE6AlG/pXkzqUcq4IYHBFACUUdelWrbTry5/1FvI3/AcfzoAq0V0Np4R1Sf76pCP9tv8K1rbwKeDcXQ9wgoA4fNGa9Lh8F6cgHmb3PfJIq3F4V0lB/x7Bvqc0AeU0Zr1weHdLHSyg/FRQ3hzS262UI+iigDyPOaK9Ul8J6S/S32/RiKoXPgmyf8A1Mjxn86APO6K6u+8FXsQzbSxzD0zg1reGPCkcUQn1SJXmzxGeQKAOU0TQrrVpB5Q2RZw0jdBXpOi6La6VDthXdIfvORya0Y40jQLGqqo6ADAFOoAKKKKACiiigAooooAK57x1D5ugSH+4wb/AD+ddDWZ4mTzNDu1/wBn+tAHkFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAb3gf/kYoPoa9UryTwncLba9bO/3SSpr1ugAooooAKKKKACiiigAooooAK5C48HR3epT3E0xWN3LBE4rr6MUAY1j4b02zwY7dWb1f5v51rRxJGMIiqPRRin0UAFFFFABRRRQAUUUUAFFFFABiiiigAooooAKKKKACiiigAooooAKz/EH/IGu/wDc/rWhWf4g/wCQLd/7n9aAPHaKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAmsTtvIT/tiva0OUU+ozXh8bbXVvQ5r2XR5xcaXayg53Rrn64oAuUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVm+I2C6Jdk/3P61pVynxCvfJ02O3VsPM3I9h/kUAecUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAV6h4EuPO0GNM8xEqfzry+u5+HN7Eqz2jsBIx3qD3oA7mgnFFHWgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAAnHWvJ/Fup/2lqjlf8AVRkqmO/vXZeNtZOnWq28P+umB59BXmfWgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigBK6Pwhokt/dpcyZS3jOc9Cx9KzND02TVL9IEB2dXb0FetWNpHZ20cEChUQYAoAnRcKBzwKdRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFNkdYo2dzhVBYn2FOpsqLJGyOMqwII9RQB5B4gvzqOqTTFiVzhc9hWdWj4i086ZqkkODsPzIfUVnUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUnsOppa3vBunfb9UDuP3UOGb3PagDtPCGkDTdPDOv7+UAuT29q6CkUYFLQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQBx3xEsBLZxXaD5ojtP0rz0V7Pqtv9rsZoD/GhWvGmUoxU9QcUAJRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAJXp/gSx+yaOJGUCSY7ifbtXmttE09zFEvV3C/ma9os4xDbpGowFUDFAE1FFFABRRRQAUUUUAFFVry+trNN9zMka/wC0cZrNTxPpTybFukB9SCBQBt0VHDNHNGHidXQ9CpyDUlABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUU12CLliAB1JoAdRWNceJNMgcq90hP+zz/ACqzYaxZXxxbXEbN/dzg/lQBoUUUUAFFFFACEV494hg+z6zdx9B5hI+ma9irzDx7EI9dLDgOgNAHOUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAGr4Vi83X7MHoH3flzXrteW+BVDeIIs9gT+hr1KgAooooAKKKKACorqZYLeSR/uopY/gKlqhrqNJpN4idTE2PyoA8q1nUptSvnllbK5wqjoBVCg8MQaWgDpvBGrSW+pJayNmCXIAPY9a9MHSvHPD8Ty61aLH13g/lzXsa9BQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFcN8QNVkjaOxgbbkbnI6/Su5ry/x3Gya4WbOGQEfmaAOcqSCWSCZZYWKupyCKZSUAeu+GdROp6XHM2N4+VseorWrlfh3GyaM5bo8pI/IV1VABRRRQAV538Rk/wCJhbP6oR/KvRK4L4kD95Zn/eH8qAOKoo70UAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABXZ+H/CC3dolxfOVEgyqL1x71xgOCK9i0G8ivNLt3hZThACAfunHSgDldS8DnJawnGP7slYNx4Y1aDObUsPVWB/rXrFFAHik1ncwnEsEqn3U1CVI6gj6ivbpIYpP9ZGjfVQaq3GlWNwpWW1iIPouP5UAed+BGx4giB7hv5GvUax7Tw7p1neJc20TJIvTDEitigAooooAKKKKACkYZUg9DS0UAeeeJPClwlw0+nR+ZG3JQHBBrAXRdSd9q2cufcYr2KjFAHJ+EfDbae32q8A+0EYCg5211lFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVgeKtCGr26GMhbiPO0nuPSt+igDx+bQtSgcq9pIcd15B/Krml+F7+8nXzojDDn5mY84r1TAowKAK2n2kdlaxwQgBEGBVmiigAooooAK4b4lL8lmfdv6V3Ncn46066v47UWsLSlSc47UAec0Vrjw3qpPFnJ+NWoPCOqyH5ogg9Sw/xoA56iuyi8C3B/1lyi/QVoW3ga1XBuLiR/ZeBQB57RXqUXhHSUHMLP9XNSf8Iro/8Az6/+Pt/jQB5TRXWeMPDkWmxJc2e4RE7WUnOK5OgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKs2N/c2MoktZWRvaq1FAHXWfji7jUC5gjl9wSprXs/G9nJxcQyRe4O6vOqKAPXIfEWlzD5bpB7MQKvwXdvOMwzI49jmvFKVWZTlSQfY0Ae40V4zFqt9Djy7uZcdMOa9O8K6g2o6THJI26RflY+9AGxRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUU2SRIxl2VR6k4oAdRUcc8UhxHIjH2OakoAKKKKACiiigAooooAKKKKACijPNFABRRRQAUUUUAFFFY2ueIbbR5Y0uElYuCRsA/xoA2aK5I+ObHtBcfkP8arzeO4h/qbRz/vNigDtaK87n8cXj/6qBE+pz/Ss6fxXqsv/LfZ/ujFAHqucUm4eorxq41S9uP9bcyt9WNVvOkP8bfnQB3nj/VIPsa2cTB5WbLYPQVwFBOetFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAldf8PNQ8m6mtGbCyYZR7/5xXI1NZXL2l1HPF9+Ngw96APbBRVewuUu7SKaM5V1BGKsUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUARXdwlrbSTSnCIMk15LrOtXep3DNJK4iz8sYOAK9G8Xgnw/d7f7vNeTUAT2t3cWsokt5njcHOVNen+FNaGrWP7wgXMZ2uPX3rymtDQb6Sw1OGWNsDcAw9RmgD2KihTkA0UAFFFFABRRRQAUUUUAFJznmloNABRRRQAUUUUAFea/EN92sRpn7qZ/OvSq8w8aW93JrU0rQS+UPlVthwR9aAOcoo6daKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigArZ8OaDLrMzYcRwp958ZrGr0P4d3ULafJbggTK24j1FACDwLa45uZfyFH/CC2n/PzL+QrsKKAOP8A+EFtP+fmX8hR/wAILaf8/Mv5CuwooA4//hBbT/n5l/IUo8C2ne5l/IV19FAFHSNOj0y0FvE7uoOQWq9RnHWkBB6EH6UALRRRQAUUUUAFFFFABRSK24ZwRzjms3xFqQ0vTJJ8ZfGEHuaAL808UP8ArZFX6miOeKUZjkVh7GvGLy8nvJjJcSM7H1OcVHHLJH9x2X6HFAHt25f7w/OoJr22h/1syL9TXjX2mf8A56yf99GoiSTkkk0Aeh+LPEdqLF7a0ZZnlBBIPCivPKKKACgHByKKKAPY9DvEvtMgmQ5JUbvY1fryjw54gl0ZnUJ5kT8lc4xXUJ46syvz284PsB/jQB19Ga851jxlcXIKWKtAh/iP3qwo9Z1GOTet5Pn3cmgD2Oiuc8JeIP7VjaG44uEGSf7wro6ACiiigAooooAKKKKACiiigApGUMMMAR71S1fUotLtDcThioOML1NU7HxNpl2Btn8tv7rjFAEuoaBp98p82BVY/wAS8GuU1TwTLHuewmEigZ2MMGu+jkSRQ0bKwPcHNOoA8TurSe1k2XEbI3oRUNe2XNrBdJsuIkkX0Zc1yGteC1fMmmMFPXy2PH4UAcFRV+80a/syfPtnAHcciqBGOtABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFS21xNayiS3kaNx3U4qKigDaHijVwMfaz/AN8r/hS/8JTq/wDz9n/vhf8ACsSigDb/AOEp1f8A5+z/AN8L/hR/wlOr/wDP2f8Avhf8KxKKANr/AISnV/8An7P/AHwv+FH/AAlOr/8AP2f++F/wrFooA0bjXNSn+/eTf8BbH8q6bwJrTtKbG6lLFstGzHJ+lcRT7ed7e4jmjOHRgwNAHt9FZmgammqafHMhG77rgdjWnQAUUUUAFFFFABXL/ECB5dHDoCRG2Wx6cV1FMniSeF4pVDI42kUAeIUV3GpeB2Mpaxn+Q87XHT8ax5PCOqq+BEjD1DUAc/RW9/wierf88F/76qxb+DNSk/1nlx/U5oA5mhQWIABJPQCu2h8COT++vAB/sp/9etvSfCljp8olO+aQdC54FAHmdzbTWzBbiNo2YbgGGMioq9X8SaBFrEIwfLnQYVgP0rznVdGvNMk23EZ29nA4NAGdRRRQAUUVc07TbrUZdlrEz+pxwKANbwGHOvpszgId36V6hWD4X0BNHiZnbfcOMMew9q3qACiiigAooooAKKKKACg0VHcSCGGSRzhUUsT7CgDh/iNfbmgs1PbewH6fyriauavetqGozXDfxHA9hVOgC/p+r31g4NvcOAP4Scj8jXX6V42jYKmoptbu6jiuBooA9psb62vo99rMkg74PIqzXitle3FlKJLaRkb2rrNO8cSoAt7Ar/7SHBoA710V1KuoYHqCM1h6p4X06+ywi8mTH3o+P06VNpniGw1DascypIf4GODWvQB5xqXgu8t13WjCcZ+6Dg1zl5Y3Nm226gkiPbcMZr2qsrxPaRXWj3AlUZVdyn0IoA8iooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiirmkWLajqENsnG9gCfQUAU6K9ctvD2mQRBBZwvgcl1BJ/Opv7F03/nxtv+/YoA8dpQrHoCfwr2H+xdN/58bb/v2Kmh06zhOYrWFD6hAKAPLtM8PX+oYMcWxP7z8Cuu0vwVawYa9kMz/3QMAV1oGOlFAFezs7ezj2W0Sxr3wOtWKr3F7bWwPnzxpjsW5qhaeIdOu7z7NBNukxkEjANAGvRRmigAooooAKKKKACiiigAooooAKKKKACkdFcYYAj3paKAMu60DTblt0tsm71AxVI+ENKLZ8tx7bv/rV0NFAGHbeF9LgbcIN5/2+a2IYI4F2woqL6AVJRQAUUUUAFFFFABRRRQAUUUUAFI6q6FXAKsMEHvVLVdTg0y2M1y2FzgAdTRpmrWepRh7WZWPdTwR+FAHP634NhucyWDCGT+4Rwa4XUNPudPmMd1GUb9DXtFQXdpBdxGO5iSRPRhmgDxSiu81rwWrbpNNYKevlseK4y+sbmxlMdzEyEeo4P40AVqKKKAAEjpxWrp/iDUbEBYZyUH8LcisqigDvLTx1GVAurVge7I2f0qh4i8W/b7Vra0iaONvvMx5IrkqKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKvaJfHTtShuOoVvmHt3qjRQB7JbatY3EKyR3cGCM4LgEfhUv2+z/AOfq3/7+D/GvFgSOhIpdzep/OgD2j7faf8/Vv/38H+NNbUrFPvXluP8AtoP8a8Z3N6n86TJ9TQB6lfeLdMtgQkvnOOyg/wA65XVPGN7c5S12wJ6gZP61y9FAEk1xLO5aaR3Y92OabDI8UqyRsVdTkEdqbSUAer+GNaj1SzXcQLhBh1/rW4Oa8X0u+l068S4gPK9R6ivWNE1OLU7FJ4iATwy5+6aANCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooozQAVXvruKzt2lncIi9yaj1PUINPtmmuHCgDIHc/SvL/EOuT6vN83yQqflQH+dACeIdYm1a7LEkQKcInoKz7a4mtZBJbyNG4OQVNQ0tAHb6J40ZQItTAI6eYo5/Gu0s7y3vIw9tMkgxn5TnFeKVYs7y4s5BJbSsje1AHtVV7yzt7yMpcwpIvuK4/R/GwO2PUowO3mJ/UV2NpdwXcQkt5FkU9wc0AcZrngvAMulkn1jY/wAq4y4tprZyk8TxsOMMpFe21BdWdvdIVuIlce4oA8Uor0PVPBVvNveylaJzyEIytcZquj3mmSFbmI7ezgcGgDPooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACr2j6nPpd2s0JJXPzJnhhVGkoA9f0XWbfVbcPCcP0ZD1Famc14paXU9nMJbWRo3HdT1rudD8ZQygR6l+7f++BwaAOyoqC3vLe5UNBMkgP8AdOanzmgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKa7qilmIAAySe1c/qnivT7MYjk8+T+7GM/rQB0LHaMngVzeveKbWwVo4P31x0AHQH3Ncfq/ie/1DciuYYSfuocE/jWFnPJ5NAFvU9RuNSuDLcuWPYdhVOiloAKKKKACiiigAq1p9/cWEwktpGQg5wDwaq0UAegaT42hkATUI2jb++vIrqbS+trxd1vMjj2NeLVLb3E1u++CV429VbFAHttI6K6lXUMp4IIrzvRvGVzb7Y78GaMcbgPmFdppes2WpIDbTKW7oeCKAM3UPCOn3c3mIDD6hBwaxta8GCG2aXT3LMvJRu9d5RQB4c6sjFXBDA4INJXY/EHTYoJ47uFQpl4YDjJ9a46gAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKSloxngUAbPheyub/AFBY4pZY4l5dlOMCvVYIxFEiAk7RjJOSaxvCOmDT9JiyP3sgDufrW7QAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAMmjWWN0cZVgQRXkviTSm0rUCnPkv8yH2r12sTxXpQ1PTSo/1sfzIaAPKKKQjaSCMEcGloAKKKKACiiigAooooAKKKKACiiigAp8M0kEgeF2Rh0INMooA6zS/Gl3AAl4izqO/Q109t4s0uWHe83ltjlSOa8sooA6Dxdrg1a5VYBi3j+7nufWufoooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACtTwzZfb9YhjPKD5m+lZddv8ADizP+k3TjrhFP8/6UAd0owMCloooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACkIz1paKAPLvG2m/YtUaZB+6mJYY7HvXPV6l4ysBe6PIQMyRHev9a8soAWiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKSgAr1rwnafY9FgQj5mG9vqa8w0u1N5qMEA/jcA/TNeywpsjUDsMUAPooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigBk6CSJkbowwa8d1q1NlqtzARgK5x9DyK9lPSvOfiJaeXqUdwOkigH6j/8AVQBydFJS0AFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSUtIelAHWfD2z87UJbll4iGAfc16OK5zwLZfZtEVnXDysXP8v6V0dABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABXK/EG2MujiUAfumBP4nH9a6qsrxRF52h3i4z+7LflzQB5DS0UUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABU1jCbm9ggHWRwv61DXR+A7P7RrQlI+WEFvx6f1oA9JtIhDbxxr0VQKmoAxRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVXv08yznQ/xIw/SrFNkGVP0oA8RmG2Z19GIptWNSTZqFwv+2ar0AFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFACV6L8PbTy9Me4YYaVzg+w4/pXnags6qOpOK9j0G3FrpFrFjBEYJ+p5NAF+iiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigApG6UtFAHjniBPL1q7H+3/SqFa3isY1+7A/vD+QrJoAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAL+gQfadYtYz0L5P4c17EgwoA6V5p8PYPN1ppCOI4yR9civTBQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAHkni7/kY7v6j+QrI71reLTnxDdn/AGh/IVk0AFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFJQB3vw1hxBdTEcsQoP5121cx8P4tmiBv7zE/rXT0AFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSN0paRulAHkPiZt2u3Z/2h/IVmVd1xt+sXRH9+qVABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRQKAPV/BybNAtfdc1t1k+FuNCsv+uS/wAq1qACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigApG+6fpS1HOdsTn/AGSaAPGdSO7ULg/7ZqvUt2d11Kf9s/zqKgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoFFJQB6z4QkEmgWmP4U21tVyvw9n8zSGjJ5jbH55rqqACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAqvfNts5z6Rsf0qxVLWW2aXdn0ib+VAHjcp3TOT/AHjSUNyxPvRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAdP4Bvhbao0EhO2ZcD6j/Jr0peRRRQAtFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABWb4iO3RL0/9MmH6UUUAeP9aKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigD/2Q==";
		// 指定Base64编码的字符串
		List<String> res = postDao.getPostList();
		for(String item:res) {
			System.out.println(item);
		}

	}
}