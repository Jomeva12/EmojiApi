package com.jomeva.myemoji.modelos

class EmojiResponse : ArrayList<EmojiResponse.EmojiResponseItem>(){
    data class EmojiResponseItem(
        var category: String, // smileys and people
        var group: String, // face positive
        var htmlCode: List<String>,
        var name: String, // grinning face
        var unicode: List<String>
    )
}