package com.leviathan143.craftingutils.client.gui.ingredientList;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Ingredient extends GuiListEntry 
{
	public final ItemStack stack;
	private String text;
	
	public Ingredient(ItemStack stack) 
	{
		this.stack = stack;
		this.text = I18n.format(stack.getUnlocalizedName() + ".name") + " x" + stack.stackSize;
	}
	
	public Ingredient(Item item) 
	{
		this(new ItemStack(item));
	}
	
	public Ingredient(Block block) 
	{
		this(new ItemStack(block));
	}
	
	@Override
	public void drawEntry(int x, int y) 
	{
		RenderHelper.enableGUIStandardItemLighting();
		mc.getRenderItem().renderItemAndEffectIntoGUI(stack, x, y);
		int colour = checked ? 0x41FF00 : 0x000000;
		mc.fontRendererObj.drawString(text, x + 18, y + 4, colour);
	}

	@Override
	public int getHeight() 
	{
		return 18;
	}

	@Override
	public int getWidth() 
	{
		return mc.fontRendererObj.getStringWidth(text) + 18;
	}

	@Override
	public void onClicked(int button) 
	{
		this.checked = true;
	}
}