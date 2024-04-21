<?php
namespace CanvasTag\Html2Pdf\Tag;

use \Spipu\Html2Pdf\Tag\AbstractTag;

/**
 * Tag CanvasTag
 */
class CanvasTag extends AbstractTag
{
	/**
	 * get the name of the tag
	 *
	 * @return string
	 */
	public function getName()
	{
		return 'canvas';
	}

	/**
	 * Open the HTML tag
	 *
	 * @param array $properties properties of the HTML tag
	 *
	 * @return boolean
	 */
	public function open($properties)
	{
		// there is nothing to do here

		return true;
	}

	/**
	 * Close the HTML tag
	 *
	 * @param array $properties properties of the HTML tag
	 *
	 * @return boolean
	 */
	public function close($properties)
	{
		// there is nothing to do here

		return true;
	}
}