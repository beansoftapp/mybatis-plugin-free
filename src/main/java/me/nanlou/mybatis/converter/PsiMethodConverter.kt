package me.nanlou.mybatis.converter

import com.intellij.psi.PsiMethod
import com.intellij.util.xml.ConvertContext
import com.intellij.util.xml.Converter
import com.intellij.util.xml.DomManager
import me.nanlou.mybatis.dom.Mapper


/**
 * @author me
 * @date  2018-08-16 09:53
 */
class PsiMethodConverter : Converter<PsiMethod>() {
    override fun toString(t: PsiMethod?, context: ConvertContext?): String? {
        return t.toString()
    }

    override fun fromString(s: String?, context: ConvertContext?): PsiMethod? {
        val mapper = DomManager
                .getDomManager(context?.project)
                .getFileElement(context?.file, Mapper::class.java)?.rootElement ?: return null
        return mapper.namespace.value?.findMethodsByName(s, false)?.getOrNull(0)
    }
}